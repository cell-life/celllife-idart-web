package org.celllife.idart.domain.prescription

import javax.validation.ConstraintViolation

/**
 */
class PrescriptionValidationException extends RuntimeException {

    Set<ConstraintViolation<Prescription>> constraintViolations

    PrescriptionValidationException(Set<ConstraintViolation<Prescription>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
