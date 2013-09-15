package org.celllife.idart.application.patient

import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.application.person.PersonApplicationService
import org.celllife.idart.common.AuthorityId
import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.OrganisationId
import org.celllife.idart.common.PatientId
import org.celllife.idart.datawarehouse.patient.PatientDataWarehouse
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.patient.PatientNotFoundException
import org.celllife.idart.domain.patient.PatientService
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisationService
import org.celllife.idart.relationship.patientorganisation.PatientOrganisationService

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.application.patient.dto.PatientDtoAssembler.*
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.PatientId.patientId
import static org.celllife.idart.domain.identifiable.IdentifiableType.FACILITY
import static org.celllife.idart.domain.identifiable.IdentifiableType.PATIENT
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier
import static org.celllife.idart.relationship.facilityorganisation.FacilityOrganisation.Relationship.OPERATED_BY
import static org.celllife.idart.relationship.patientorganisation.PatientOrganisation.Relationship.REGISTERED_WITH

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h36
 */
@Named class PatientApplicationServiceImpl implements PatientApplicationService {

    @Inject PatientService patientService

    @Inject PatientProvider prehmisPatientProvider

    @Inject PersonApplicationService personApplicationService

    @Inject IdentifiableService identifiableService

    @Inject FacilityOrganisationService facilityOrganisationService

    @Inject PatientOrganisationService patientOrganisationService

    @Inject PatientDataWarehouse patientDataWarehouse

    @Override
    PatientId save(PatientDto patientDto) {

        def personDto = patientDto.person

        def identifiable = identifiableService.findByIdentifiers(PATIENT, patientDto.identifiers)
        if (identifiable != null) {

            def patientId = patientId(identifiable.getIdentifier(IDART).value)
            def patient = patientService.findByPatientId(patientId)

            def personExists = personApplicationService.exists(patient.person)
            if (personExists) {

                // Scenario 1 - Both Patient and Person exists

                personApplicationService.save(personDto)

                copyToPatient(patientDto, patient)
                patient = patientService.save(patient)

                patient.id

            } else {

                // Scenario 2 - Patient exists but Person does not

                // How did we manage to create a Patient without a Person... very very bad
                throw new PatientWithoutAPersonException("Something bad happened")
            }

        } else {

            // Scenario 3 - Patient does not exist, but Person does

            // Scenario 4 - Patient and Person don't exist

            def patient = toPatient(patientDto)
            patient.person = personApplicationService.save(personDto)

            patient = patientService.save(patient)

            identifiable = new Identifiable(type: PATIENT, identifiers: patientDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, patient.id.value))
            identifiableService.save(identifiable)

            patient.id
        }
    }

    @Override
    PatientDto findByPatientId(PatientId patientId) {

        findByIdentifier(newIdentifier(IDART, patientId.value))
    }

    @Override
    PatientDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(PATIENT, [identifier] as Set)

        if (identifiable == null) {
            throw new PatientNotFoundException("Could not find Patient with id [${identifier.value}]")
        }

        def patientId = patientId(identifiable.getIdentifier(IDART).value)

        def patient = patientService.findByPatientId(patientId)

        def patientDto = toPatientDto(patient)
        patientDto.identifiers = identifiable.identifiers
        patientDto.person = personApplicationService.findByPersonId(patient.person)

        return patientDto
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

        def facilityIdentifiable = identifiableService.findByIdentifiers(FACILITY, [newIdentifier(IDART, facility.value)] as Set)

        def patients = facilityIdentifiable.identifiers.collect() { facilityIdentifier ->

            switch (facilityIdentifier.authority) {
                case AuthorityId.PREHMIS:
                    return prehmisPatientProvider.findByIdentifier(facilityIdentifier.value, patientIdentifier)
                default:
                    return [] as Set<PatientDto>
            }
        }

        patients.flatten()
    }
}
