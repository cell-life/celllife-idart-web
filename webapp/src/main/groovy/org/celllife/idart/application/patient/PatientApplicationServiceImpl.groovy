package org.celllife.idart.application.patient

import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.application.patient.dto.PatientDtoAssembler
import org.celllife.idart.application.person.PersonApplicationService
import org.celllife.idart.common.*
import org.celllife.idart.datawarehouse.patient.PatientDataWarehouse
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.patient.PatientNotFoundException
import org.celllife.idart.domain.patient.PatientService
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisationService
import org.celllife.idart.relationship.patientorganisation.PatientOrganisationService
import org.celllife.idart.relationship.systemfacility.SystemFacilityService

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

import static org.celllife.idart.common.IdentifiableType.FACILITY
import static org.celllife.idart.common.IdentifiableType.PATIENT
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.newIdentifiers
import static org.celllife.idart.common.PatientId.patientId
import static org.celllife.idart.common.Systems.IDART_WEB
import static org.celllife.idart.common.Systems.PREHMIS
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
    @Transactional
    PatientId save(PatientDto patientDto) {

        def personDto = patientDto.person

        def patientExists = identifiableService.exists(PATIENT, patientDto.identifiers)
        if (patientExists) {

            def identifiable = identifiableService.resolveIdentifiable(PATIENT, patientDto.identifiers)
            patientDto.identifiers = identifiable.identifiers

            def patientId = patientId(identifiable.getIdentifierValue(IDART_WEB.id))
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
            personDto.identifiers << newIdentifier(IDART_WEB.id, person.value)
            patient.person = personApplicationService.save(personDto)
            patient = patientService.save(patient)

            patient.id

        } else {

            // Scenario 3 - Patient does not exist, but Person does

            // Scenario 4 - Patient and Person don't exist

            def identifiable = identifiableService.resolveIdentifiable(PATIENT, patientDto.identifiers)
            patientDto.identifiers = identifiable.identifiers

            def patientId = patientId(identifiable.getIdentifierValue(IDART_WEB.id))
            def patient = patientDtoAssembler.toPatient(patientDto)
            patient.id = patientId

            patient.person = personApplicationService.save(personDto)
            patient = patientService.save(patient)

            patient.id
        }
    }

    @Override
    @Transactional(readOnly = true)
    PatientDto findByPatientId(PatientId patientId) {

        findByIdentifier(newIdentifier(patientId.value))
    }

    @Override
    @Transactional(readOnly = true)
    PatientDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(PATIENT, [identifier] as Set)
        if (identifiable == null) {
            throw new PatientNotFoundException("Could not find Patient with id [${identifier}]")
        }

        def patientId = patientId(identifiable.getIdentifierValue(IDART_WEB.id))

        def patient = patientService.findByPatientId(patientId)

        def patientDto = patientDtoAssembler.toPatientDto(patient)
        patientDto.identifiers = identifiable.identifiers
        patientDto.person = personApplicationService.findByPersonId(patient.person)

        return patientDto
    }

    @Override
    @Transactional(readOnly = true)
    PatientId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.findByIdentifiers(PATIENT, identifiers)
        if (identifiable == null) {
            throw new PatientNotFoundException("Could not find Patient with id [${identifiers}]")
        }

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        patientId(idartIdentifierValue)
    }

    @Override
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    Set<PatientDto> findByIdentifierAndSystem(String identifier, SystemId system) {

        def facility = systemFacilityService.findFacility(system, DEPLOYED_AT)

        def patients = findByIdentifierAndFacility(identifier, facility)

        patients
    }

    @Override
    @Transactional(readOnly = true)
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

        def facilityIdentifiable = identifiableService.resolveIdentifiable(FACILITY, newIdentifiers(IDART_WEB.id, facility.value))

        def patients = facilityIdentifiable.identifiers.collect() { facilityIdentifier ->

            switch (facilityIdentifier.system) {
                case PREHMIS.id:
                    return prehmisPatientProvider.findByIdentifier(facilityIdentifier.value, patientIdentifier)
                default:
                    return [] as Set<PatientDto>
            }
        }

        patients.flatten()
    }
}
