package org.celllife.idart.application.practitioner

import org.celllife.idart.application.person.PersonApplicationService
import org.celllife.idart.application.practitioner.dto.PractitionerDto
import org.celllife.idart.application.practitioner.dto.PractitionerDtoAssembler
import org.celllife.idart.common.AuthorityId
import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.OrganisationId
import org.celllife.idart.common.PersonId
import org.celllife.idart.common.PractitionerId
import org.celllife.idart.common.SystemId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.practitioner.PractitionerNotFoundException
import org.celllife.idart.domain.practitioner.PractitionerService
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisationService
import org.celllife.idart.relationship.practitionerorganisation.PractitionerOrganisationService
import org.celllife.idart.relationship.systemfacility.SystemFacility
import org.celllife.idart.relationship.systemfacility.SystemFacilityService

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.application.practitioner.dto.PractitionerDtoAssembler.copyToPractitioner
import static org.celllife.idart.application.practitioner.dto.PractitionerDtoAssembler.toPractitioner
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.PractitionerId.practitionerId
import static org.celllife.idart.domain.identifiable.IdentifiableType.FACILITY
import static org.celllife.idart.domain.identifiable.IdentifiableType.PRACTITIONER
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier
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

    @Inject PractitionerProvider prehmisPractitionerProvider

    @Inject PersonApplicationService personApplicationService

    @Inject IdentifiableService identifiableService

    @Inject FacilityOrganisationService facilityOrganisationService

    @Inject PractitionerOrganisationService practitionerOrganisationService

    @Inject SystemFacilityService systemFacilityService

    @Override
    PractitionerId save(PractitionerDto practitionerDto) {

        def personDto = practitionerDto.person

        def identifiable = identifiableService.findByIdentifiers(PRACTITIONER, practitionerDto.identifiers)
        if (identifiable != null) {

            def practitionerId = practitionerId(identifiable.getIdentifier(IDART).value)
            def practitioner = practitionerService.findByPractitionerId(practitionerId)

            def personExists = personApplicationService.exists(practitioner.person)
            if (personExists) {

                // Scenario 1 - Both Practitioner and Person exists

                personApplicationService.save(personDto)

                copyToPractitioner(practitionerDto, practitioner)
                practitioner = practitionerService.save(practitioner)

                practitioner.id

            } else {

                // Scenario 2 - Practitioner exists but Person does not

                // How did we manage to create a Practitioner without a Person... very very bad
                throw new PractitionerWithoutAPersonException("Something bad happened")
            }

        } else {

            // Scenario 3 - Practitioner does not exist, but Person does

            // Scenario 4 - Practitioner and Person don't exist

            def practitioner = toPractitioner(practitionerDto)
            practitioner.person = personApplicationService.save(personDto)

            practitioner = practitionerService.save(practitioner)

            identifiable = new Identifiable(type: PRACTITIONER, identifiers: practitionerDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, practitioner.id.value))
            identifiableService.save(identifiable)

            practitioner.id
        }
    }

    @Override
    PractitionerDto findByPractitionerId(PractitionerId practitionerId) {

        findByIdentifier(newIdentifier(IDART, practitionerId.value))
    }

    @Override
    PractitionerDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(PRACTITIONER, [identifier] as Set)

        if (identifiable == null) {
            throw new PractitionerNotFoundException("Could not find Practitioner with id [${identifier.value}]")
        }

        def practitionerId = practitionerId(identifiable.getIdentifier(IDART).value)

        def practitioner = practitionerService.findByPractitionerId(practitionerId)

        def practitionerDto = PractitionerDtoAssembler.toPractitionerDto(practitioner)
        practitionerDto.identifiers = identifiable.identifiers
        practitionerDto.person = personApplicationService.findByPersonId(practitioner.person)

        practitionerDto
    }

    @Override
    Set<PractitionerDto> findByFacility(FacilityId facilityId) {

        Iterable<OrganisationId> organisationIds = facilityOrganisationService.findOrganisations(facilityId, OPERATED_BY)

        lookupFromExternalProvidersAndSave(facilityId, organisationIds)

        organisationIds
                .collect { organisationId -> practitionerOrganisationService.findPractitioners(organisationId, CONTRACTED_BY) }
                .flatten()
                .collect { practitionerId -> findByPractitionerId(practitionerId) }

    }

    Set<PractitionerDto> findBySystem(SystemId system) {

        systemFacilityService.findFacilities(system, DEPLOYED_AT)
                .collect { facility -> findByFacility(facility) }
                .flatten()
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

        def facilityIdentifiable = identifiableService.findByIdentifiers(FACILITY, [newIdentifier(IDART, facility.value)] as Set)

        def practitioners = facilityIdentifiable.identifiers.collect() { facilityIdentifier ->

            switch (facilityIdentifier.authority) {
                case AuthorityId.PREHMIS:
                    return prehmisPractitionerProvider.findAll(facilityIdentifier.value)
                default:
                    return [] as Set<PractitionerDto>
            }
        }

        practitioners.flatten()
    }
}
