package org.celllife.idart.application.prescription.dto

import org.celllife.idart.application.encounter.EncounterApplicationService
import org.celllife.idart.application.patient.PatientApplicationService
import org.celllife.idart.application.practitioner.PractitionerApplicationService
import org.celllife.idart.domain.prescription.Prescription

import javax.inject.Inject
import javax.inject.Named

/**
 */
@Named class PrescriptionDtoAssembler {

    @Inject PractitionerApplicationService practitionerApplicationService

    @Inject PatientApplicationService patientApplicationService

    @Inject EncounterApplicationService encounterApplicationService

    Prescription toPrescription(PrescriptionDto prescriptionDto) {

        def prescription = new Prescription()
        prescription.with {
            prescriber = practitionerApplicationService.findByIdentifiers(prescriptionDto.prescriber)
            patient = patientApplicationService.findByIdentifiers(prescriptionDto.patient)
            dateWritten = prescriptionDto.dateWritten
        }

        prescription
    }

    PrescriptionDto toPrescriptionDto(Prescription prescription) {

        def prescriptionDto = new PrescriptionDto()
        prescriptionDto.with {
            prescriber = practitionerApplicationService.findByPractitionerId(prescription.prescriber).identifiers
            patient = patientApplicationService.findByPatientId(prescription.patient).identifiers
            dateWritten = prescription.dateWritten
        }

        prescriptionDto
    }
}
