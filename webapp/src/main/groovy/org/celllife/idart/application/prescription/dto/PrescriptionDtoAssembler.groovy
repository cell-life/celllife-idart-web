package org.celllife.idart.application.prescription.dto

import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PrescriptionDtoAssembler {

    static Prescription toPrescription(PrescriptionDto prescriptionDto) {

        def prescription = new Prescription()
        prescription.with {

        }

        prescription
    }

    static PrescriptionDto toPrescriptionDto(Prescription prescription) {

        def prescriptionDto = new PrescriptionDto()
        prescriptionDto.with {

        }

        prescriptionDto
    }
}
