package org.celllife.idart.domain.prescribedmedication

import javax.validation.ConstraintViolation

/**
 */
class PrescribedMedicationValidationException extends RuntimeException {

    Set<ConstraintViolation<PrescribedMedication>> constraintViolations

    PrescribedMedicationValidationException(Set<ConstraintViolation<PrescribedMedication>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
