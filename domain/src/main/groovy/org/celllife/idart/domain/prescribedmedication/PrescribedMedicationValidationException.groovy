package org.celllife.idart.domain.prescribedmedication

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PrescribedMedicationValidationException extends RuntimeException {

    Set<ConstraintViolation<PrescribedMedication>> constraintViolations

    PrescribedMedicationValidationException(Set<ConstraintViolation<PrescribedMedication>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
