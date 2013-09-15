package org.celllife.idart.application.prescribedmedication.dto

import org.celllife.idart.domain.prescribedmedication.PrescribedMedication
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PrescribedMedicationDtoAssembler {

    static PrescribedMedication toPrescribedMedication(PrescribedMedicationDto prescribedMedicationDto) {

        def prescribedMedication = new PrescribedMedication()
        prescribedMedication.with {

        }

        prescribedMedication
    }

    static PrescribedMedicationDto toPrescribedMedicationDto(PrescribedMedication prescribedMedication) {

        def prescribedMedicationDto = new PrescribedMedicationDto()
        prescribedMedicationDto.with {

        }

        prescribedMedicationDto
    }
}
