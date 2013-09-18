package org.celllife.idart.application.patient

import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.application.patient.dto.PatientDtoAssembler
import org.celllife.idart.application.person.PersonApplicationService
import org.celllife.idart.common.PersonId
import org.celllife.idart.common.SystemId
import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.OrganisationId
import org.celllife.idart.common.PatientId
import org.celllife.idart.datawarehouse.patient.PatientDataWarehouse
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.patient.PatientNotFoundException
import org.celllife.idart.domain.patient.PatientService
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisationService
import org.celllife.idart.relationship.patientorganisation.PatientOrganisationService
import org.celllife.idart.relationship.systemfacility.SystemFacility
import org.celllife.idart.relationship.systemfacility.SystemFacilityService

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.common.SystemId.IDART_WEB
import static org.celllife.idart.common.PatientId.patientId
import static org.celllife.idart.common.IdentifiableType.FACILITY
import static org.celllife.idart.common.IdentifiableType.PATIENT
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.relationship.facilityorganisation.FacilityOrganisation.Relationship.OPERATED_BY
import static org.celllife.idart.relationship.patientorganisation.PatientOrganisation.Relationship.REGISTERED_WITH
import static org.celllife.idart.relationship.systemfacility.SystemFacility.Relationship.DEPLOYED_AT

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h36
 */
@Named class PatientApplicationServiceImpl implements PatientApplicationService {

    @Inject PatientService patientService

    @Inject PatientDtoAssembler patientDtoAssembler

    @Inject PatientProvider prehmisPatientProvider

    @Inject PersonApplicationService personApplicationService

    @Inject IdentifiableService identifiableService

    @Inject FacilityOrganisationService facilityOrganisationService

    @Inject PatientOrganisationService patientOrganisationService

    @Inject PatientDataWarehouse patientDataWarehouse

    @Inject SystemFacilityService systemFacilityService

    @Override
    PatientId save(PatientDto patientDto) {

        def personDto = patientDto.person

        def patientExists = identifiableService.exists(PATIENT, patientDto.identifiers)
        if (patientExists) {

            def identifiable = identifiableService.resolveIdentifiable(PATIENT, patientDto.identifiers)
            patientDto.identifiers = identifiable.identifiers

            def patientId = patientId(identifiable.getIdentifierValue(IDART_WEB))
            def patient = patientDtoAssembler.toPatient(patientDto)
            patient.id = patientId

            def person = patientService.findPersonByPatientId(patient.id)
            def personExists = personApplicationService.exists(person)
            if (!personExists) {
                // Scenario 2 - Patient exists but Person does not

                // How did we manage to create a Patient without a Person... very very bad
                throw new PatientWithoutAPersonException("Something bad happened")
            }

            // Scenario 1 - Both Patient and Person exists
            patient.person = personApplicationService.save(personDto)
            patient = patientService.save(patient)

            patient.id

        } else {

            // Scenario 3 - Patient does not exist, but Person does

            // Scenario 4 - Patient and Person don't exist

            def identifiable = identifiableService.resolveIdentifiable(PATIENT, patientDto.identifiers)
            patientDto.identifiers = identifiable.identifiers

            def patientId = patientId(identifiable.getIdentifierValue(IDART_WEB))
            def patient = patientDtoAssembler.toPatient(patientDto)
            patient.id = patientId

            patient.person = personApplicationService.save(personDto)
            patient = patientService.save(patient)

            patient.id
        }
    }

    @Override
    PatientDto findByPatientId(PatientId patientId) {

        findByIdentifier(newIdentifier(IDART_WEB, patientId.value))
    }

    @Override
    PatientDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(PATIENT, [identifier] as Set)

        if (identifiable == null) {
            throw new PatientNotFoundException("Could not find Patient with id [${identifier.value}]")
        }

        def patientId = patientId(identifiable.getIdentifierValue(IDART_WEB))

        def patient = patientService.findByPatientId(patientId)

        def patientDto = patientDtoAssembler.toPatientDto(patient)
        patientDto.identifiers = identifiable.identifiers
        patientDto.person = personApplicationService.findByPersonId(patient.person)

        return patientDto
    }

    @Override
    PatientId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(PATIENT, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB)

        patientId(idartIdentifierValue)
    }

    @Override
    Set<PatientDto> findByIdentifierAndFacility(String patientIdentifier, FacilityId facilityId) {

        Iterable<OrganisationId> organisationIds = facilityOrganisationService.findOrganisations(facilityId, OPERATED_BY)

        lookupFromExternalProvidersAndSave(patientIdentifier, facilityId, organisationIds)

        def patientIds = organisationIds.collect { organisation ->
            patientDataWarehouse.findByIdentifierAndOrganisation(patientIdentifier, REGISTERED_WITH, organisation)
        }

        def flattenedPatientIds = patientIds.flatten()

        def patients = flattenedPatientIds.collect { patientId -> findByPatientId(patientId) }

        patients
    }

    @Override
    Set<PatientDto> findByIdentifierAndSystem(String identifier, SystemId system) {

        systemFacilityService.findFacilities(system, DEPLOYED_AT)
                .collect { facility -> findByIdentifierAndFacility(identifier, facility) }
                .flatten()

    }

    @Override
    Set<PatientDto> findByIdentifierAndPerson(String identifier, PersonId personId) {
        return null
    }

    def lookupFromExternalProvidersAndSave(String patientIdentifier,
                                           FacilityId facilityId,
                                           Iterable<OrganisationId> organisationIds) {

        def patientDtos = lookupFromExternalProviders(patientIdentifier, facilityId)
        patientDtos.each { patientDto ->

            def patientId = save(patientDto)

            organisationIds.each { organisationId ->
                patientOrganisationService.save(patientId, organisationId, REGISTERED_WITH)
            }
        }
    }

    Set<PatientDto> lookupFromExternalProviders(String patientIdentifier, FacilityId facility) {

        def facilityIdentifiable = identifiableService.resolveIdentifiable(FACILITY, [newIdentifier(IDART_WEB, facility.value)] as Set)

        def patients = facilityIdentifiable.identifiers.collect() { facilityIdentifier ->

            switch (facilityIdentifier.system) {
                case SystemId.PREHMIS:
                    return prehmisPatientProvider.findByIdentifier(facilityIdentifier.value, patientIdentifier)
                default:
                    return [] as Set<PatientDto>
            }
        }

        patients.flatten()
    }
}
