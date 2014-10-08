package org.celllife.idart.domain.prescription

import javax.validation.ConstraintViolation

/**
 */
class PrescriptionValidationException extends RuntimeException {

    PrescriptionValidationException(Set<ConstraintViolation<Prescription>> constraintViolations) {
        super(constraintViolations);
    }
}
