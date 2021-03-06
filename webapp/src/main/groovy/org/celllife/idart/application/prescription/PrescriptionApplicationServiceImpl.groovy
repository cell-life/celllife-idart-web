package org.celllife.idart.application.prescription

import java.util.Set;

import org.celllife.idart.application.encounter.EncounterApplicationService
import org.celllife.idart.application.encounter.dto.EncounterDto
import org.celllife.idart.application.patient.dto.PatientDto;
import org.celllife.idart.application.prescribedmedication.PrescribedMedicationApplicationService
import org.celllife.idart.application.prescription.dto.PrescriptionDto
import org.celllife.idart.application.prescription.dto.PrescriptionDtoAssembler
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.PersonId;
import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.common.SystemId
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.prescription.PrescriptionNotFoundException
import org.celllife.idart.domain.prescription.PrescriptionService
import org.celllife.idart.relationship.systemfacility.SystemFacilityService

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

import static org.celllife.idart.common.IdentifiableType.PRESCRIPTION
import static org.celllife.idart.common.IdentifiableType.FACILITY
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.newIdentifiers
import static org.celllife.idart.common.PrescriptionId.prescriptionId
import static org.celllife.idart.common.Systems.IDART_WEB
import static org.celllife.idart.common.Systems.PREHMIS
import static org.celllife.idart.relationship.facilityorganisation.FacilityOrganisation.Relationship.OPERATED_BY
import static org.celllife.idart.relationship.patientorganisation.PatientOrganisation.Relationship.REGISTERED_WITH
import static org.celllife.idart.relationship.systemfacility.SystemFacility.Relationship.DEPLOYED_AT

/**
 */
@Named class PrescriptionApplicationServiceImpl implements PrescriptionApplicationService {

    @Inject PrescriptionService prescriptionService

    @Inject PrescribedMedicationApplicationService prescribedMedicationApplicationService

    @Inject PrescriptionDtoAssembler prescriptionDtoAssembler

    @Inject IdentifiableService identifiableService

    @Inject EncounterApplicationService encounterApplicationService

    @Inject SystemFacilityService systemFacilityService

    @Override
    @Transactional(readOnly = true)
    Boolean exists(PrescriptionId prescriptionId) {
        prescriptionService.exists(prescriptionId)
    }

    @Override
    @Transactional
    PrescriptionId save(SystemId systemId, PrescriptionDto prescriptionDto) {

        def facility = systemFacilityService.findFacility(systemId, DEPLOYED_AT)

        if (prescriptionDto.encounter == null) {
            prescriptionDto.encounter = new EncounterDto()
        }

        prescriptionDto.encounter.facility << newIdentifier(facility.value)

        save(prescriptionDto)
    }

    @Override
    @Transactional
    PrescriptionId save(PrescriptionDto prescriptionDto) {

        def identifiable = identifiableService.resolveIdentifiable(PRESCRIPTION, prescriptionDto.identifiers)
        prescriptionDto.identifiers = identifiable.identifiers

        def prescriptionId = prescriptionId(identifiable.getIdentifierValue(IDART_WEB.id))

        def prescription = prescriptionDtoAssembler.toPrescription(prescriptionDto)
        prescription.id = prescriptionId
        prescription.encounter = encounterApplicationService.save(prescriptionDto.encounter)
        prescription.prescribedMedications = prescriptionDto.prescribedMedications.collect { prescribedMedicationDto ->
            prescribedMedicationApplicationService.save(prescribedMedicationDto)
        }

        prescriptionService.save(prescription)

        prescription.id
    }

    @Override
    @Transactional(readOnly = true)
    PrescriptionDto findByPrescriptionId(PrescriptionId prescriptionId) {
        def identifier = newIdentifier(prescriptionId.value)
        findByIdentifier(identifier)
    }

    @Override
    @Transactional(readOnly = true)
    PrescriptionDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(PRESCRIPTION, [identifier] as Set)
        if (identifiable == null) {
            throw new PrescriptionNotFoundException("Could not find Prescription with id [${identifier}]")
        }

        def prescriptionId = prescriptionId(identifiable.getIdentifierValue(IDART_WEB.id))

        def prescription = prescriptionService.findByPrescriptionId(prescriptionId)

        def prescriptionDto = prescriptionDtoAssembler.toPrescriptionDto(prescription)
        prescriptionDto.identifiers = identifiable.identifiers
        prescriptionDto.encounter = encounterApplicationService.findByEncounterId(prescription.encounter)
        prescriptionDto.prescribedMedications = prescription.prescribedMedications.collect { prescribedMedication ->
            prescribedMedicationApplicationService.findByPrescribedMedicationId(prescribedMedication)
        }

        prescriptionDto
    }


    @Override
    @Transactional(readOnly = true)
    PrescriptionId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.findByIdentifiers(PRESCRIPTION, identifiers)
        if (identifiable == null) {
            throw new PrescriptionNotFoundException("Could not find Prescription with id [${identifiers}]")
        }

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        prescriptionId(idartIdentifierValue)
    }

	@Override
    @Transactional
	void deleteByPrescriptionId(PrescriptionId prescriptionId) {
		prescriptionService.deleteByPrescriptionId(prescriptionId)
	}

    @Override
    @Transactional
    void deleteByIdentifierAndSystem(String identifier, SystemId system) {

        // get the information about the facility
        def facility = systemFacilityService.findFacility(system, DEPLOYED_AT)
        def facilityIdentifiable = identifiableService.resolveIdentifiable(FACILITY, newIdentifiers(IDART_WEB.id, facility.value))

        def patients = facilityIdentifiable.identifiers.collect() { facilityIdentifier ->

            // convert the specified prescription id to an iDARTweb id
            def identifiable = identifiableService.findByIdentifiers(PRESCRIPTION, newIdentifiers(system, identifier))
            if (identifiable == null) {
                throw new PrescriptionNotFoundException("Could not find Prescription with id [${system} - ${identifier}]")
            }
            def idartwebId = identifiable.getIdentifierValue(IDART_WEB.id)
            
            switch (facilityIdentifier.system) {
                case PREHMIS.id:
                    prescriptionService.deleteByPrescriptionId(PrescriptionId.prescriptionId(idartwebId))
            }
        }
    }

    @Override
    @Transactional
    void deleteByIdentifierAndPerson(String identifier, PersonId personId) {
        // no implementation for online system yet
        
    }
}
