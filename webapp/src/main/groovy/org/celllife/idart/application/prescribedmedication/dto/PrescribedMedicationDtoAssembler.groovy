package org.celllife.idart.application.prescribedmedication.dto

import org.celllife.idart.application.product.ProductApplicationService
import org.celllife.idart.domain.prescribedmedication.PrescribedMedication

import javax.inject.Inject
import javax.inject.Named

/**
 */
@Named class PrescribedMedicationDtoAssembler {

    @Inject ProductApplicationService productApplicationService

    PrescribedMedication toPrescribedMedication(PrescribedMedicationDto prescribedMedicationDto) {

        def prescribedMedication = new PrescribedMedication()
        prescribedMedication.with {
            medication = productApplicationService.findByIdentifiers(prescribedMedicationDto.medication)
            reasonForPrescribing = prescribedMedicationDto.reasonForPrescribing
            indications = prescribedMedicationDto.indications
            valid = prescribedMedicationDto.valid
            numberOfRepeats = prescribedMedicationDto.numberOfRepeats
            quantity = prescribedMedicationDto.quantity
            expectedSupplyDuration = prescribedMedicationDto.expectedSupplyDuration
            substitution = prescribedMedicationDto.substitution
            substitutionReason = prescribedMedicationDto.substitutionReason
            dosageInstruction = prescribedMedicationDto.dosageInstruction
        }

        prescribedMedication
    }

    PrescribedMedicationDto toPrescribedMedicationDto(PrescribedMedication prescribedMedication) {

        def prescribedMedicationDto = new PrescribedMedicationDto()
        prescribedMedicationDto.with {
            medication = productApplicationService.findByProductId(prescribedMedication.medication).identifiers
            reasonForPrescribing = prescribedMedication.reasonForPrescribing
            indications = prescribedMedication.indications
            valid = prescribedMedication.valid
            numberOfRepeats = prescribedMedication.numberOfRepeats
            quantity = prescribedMedication.quantity
            expectedSupplyDuration = prescribedMedication.expectedSupplyDuration
            substitution = prescribedMedication.substitution
            substitutionReason = prescribedMedication.substitutionReason
            dosageInstruction = prescribedMedication.dosageInstruction
        }

        prescribedMedicationDto
    }
}
