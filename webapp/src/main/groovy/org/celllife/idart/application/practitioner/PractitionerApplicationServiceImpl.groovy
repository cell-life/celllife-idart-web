package org.celllife.idart.application.practitioner

import org.celllife.idart.application.person.PersonApplicationService
import org.celllife.idart.application.practitioner.dto.PractitionerDto
import org.celllife.idart.application.practitioner.dto.PractitionerDtoAssembler
import org.celllife.idart.common.*
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.practitioner.PractitionerNotFoundException
import org.celllife.idart.domain.practitioner.PractitionerService
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisationService
import org.celllife.idart.relationship.practitionerorganisation.PractitionerOrganisationService
import org.celllife.idart.relationship.systemfacility.SystemFacilityService

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

import static IdentifiableType.FACILITY
import static IdentifiableType.PRACTITIONER
import static Identifiers.getIdentifierValue
import static Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.newIdentifiers
import static org.celllife.idart.common.PractitionerId.practitionerId
import static org.celllife.idart.common.Systems.IDART_WEB
import static org.celllife.idart.common.Systems.PREHMIS
import static org.celllife.idart.relationship.facilityorganisation.FacilityOrganisation.Relationship.OPERATED_BY
import static org.celllife.idart.relationship.practitionerorganisation.PractitionerOrganisation.Relationship.CONTRACTED_BY
import static org.celllife.idart.relationship.systemfacility.SystemFacility.Relationship.DEPLOYED_AT

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 12h16
 */
@Named class PractitionerApplicationServiceImpl implements PractitionerApplicationService {

    @Inject PractitionerService practitionerService

    @Inject PractitionerDtoAssembler practitionerDtoAssembler

    @Inject PractitionerProvider prehmisPractitionerProvider

    @Inject PersonApplicationService personApplicationService

    @Inject IdentifiableService identifiableService

    @Inject FacilityOrganisationService facilityOrganisationService

    @Inject PractitionerOrganisationService practitionerOrganisationService

    @Inject SystemFacilityService systemFacilityService

    @Override
    @Transactional
    PractitionerId save(PractitionerDto practitionerDto) {

        def personDto = practitionerDto.person

        def practitionerExists = identifiableService.exists(PRACTITIONER, practitionerDto.identifiers)
        if (practitionerExists) {

            def identifiable = identifiableService.resolveIdentifiable(PRACTITIONER, practitionerDto.identifiers)
            practitionerDto.identifiers = identifiable.identifiers

            def practitionerId = practitionerId(identifiable.getIdentifierValue(IDART_WEB.id))
            def practitioner = practitionerDtoAssembler.toPractitioner(practitionerDto)
            practitioner.id = practitionerId

            def personId = practitionerService.findPersonByPractitionerId(practitioner.id)
            if (personId == null) {
                // Scenario 5 - The identifiers have been created, but not the person entity.
                practitioner.person = personApplicationService.save(personDto)
            } else {
                def personExists = personApplicationService.exists(personId)
                if (!personExists) {
                    // Scenario 2 - Practitioner exists but Person does not
                    practitioner.person = personApplicationService.save(personDto)
                } else {
                    // Scenario 1 - Both Practitioner and Person exists
                    personDto.identifiers << newIdentifier(IDART_WEB.id, personId.value)
                    practitioner.person = personApplicationService.save(personDto)
                    practitioner = practitionerService.save(practitioner)
                }
            }

            practitioner.id

        } else {

            // Scenario 3 - Practitioner does not exist, but Person does

            // Scenario 4 - Practitioner and Person don't exist

            def identifiable = identifiableService.resolveIdentifiable(PRACTITIONER, practitionerDto.identifiers)
            practitionerDto.identifiers = identifiable.identifiers

            def practitionerId = practitionerId(identifiable.getIdentifierValue(IDART_WEB.id))
            def practitioner = practitionerDtoAssembler.toPractitioner(practitionerDto)
            practitioner.id = practitionerId

            practitioner.person = personApplicationService.save(personDto)
            practitioner = practitionerService.save(practitioner)

            practitioner.id
        }
    }

    @Override
    @Transactional(readOnly = true)
    PractitionerDto findByPractitionerId(PractitionerId practitionerId) {

        findByIdentifier(newIdentifier(practitionerId.value))
    }

    @Override
    @Transactional(readOnly = true)
    PractitionerDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(PRACTITIONER, [identifier] as Set)
        if (identifiable == null) {
            throw new PractitionerNotFoundException("Could not find Practitioner with id [${identifier}]")
        }

        def practitionerId = practitionerId(identifiable.getIdentifierValue(IDART_WEB.id))

        def practitioner = practitionerService.findByPractitionerId(practitionerId)

        def practitionerDto = practitionerDtoAssembler.toPractitionerDto(practitioner)
        practitionerDto.identifiers = identifiable.identifiers
        practitionerDto.person = personApplicationService.findByPersonId(practitioner.person)

        practitionerDto
    }

    @Override
    @Transactional(readOnly = true)
    PractitionerId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.findByIdentifiers(PRACTITIONER, identifiers)
        if (identifiable == null) {
            throw new PractitionerNotFoundException("Could not find Practitioner with id [${identifiers}]")
        }

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        practitionerId(idartIdentifierValue)
    }

    @Override
    @Transactional(readOnly = true)
    Set<PractitionerDto> findByFacility(FacilityId facilityId) {

        Iterable<OrganisationId> organisationIds = facilityOrganisationService.findOrganisations(facilityId, OPERATED_BY)

        lookupFromExternalProvidersAndSave(facilityId, organisationIds)

        organisationIds
                .collect { organisationId -> practitionerOrganisationService.findPractitioners(organisationId, CONTRACTED_BY) }
                .flatten()
                .collect { practitionerId -> findByPractitionerId(practitionerId) }

    }

    Set<PractitionerDto> findBySystem(SystemId system) {

        def facility = systemFacilityService.findFacility(system, DEPLOYED_AT)

        def practitioners = findByFacility(facility)

        practitioners
    }

    Set<PractitionerDto> findByPerson(PersonId personId) {

    }

    def lookupFromExternalProvidersAndSave(FacilityId facilityId, Iterable<OrganisationId> organisationIds) {

        def practitionerDtos = lookupFromExternalProviders(facilityId)
        practitionerDtos.each { practitionerDto ->

            def practitionerId = save(practitionerDto)

            organisationIds.each { organisationId ->
                practitionerOrganisationService.save(practitionerId, organisationId, CONTRACTED_BY)
            }
        }
    }

    Set<PractitionerDto> lookupFromExternalProviders(FacilityId facility) {

        def facilityIdentifiable = identifiableService.resolveIdentifiable(FACILITY, newIdentifiers(facility.value))

        def practitioners = facilityIdentifiable.identifiers.collect() { facilityIdentifier ->

            switch (facilityIdentifier.system) {
                case PREHMIS.id:
                    return prehmisPractitionerProvider.findAll(facilityIdentifier.value)
                default:
                    return [] as Set<PractitionerDto>
            }
        }

        practitioners.flatten()
    }
}