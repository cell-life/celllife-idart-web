package org.celllife.idart.domain.dispensation

import javax.validation.ConstraintViolation

/**
 */
class DispensationValidationException extends RuntimeException {

    Set<ConstraintViolation<Dispensation>> constraintViolations

    DispensationValidationException(Set<ConstraintViolation<Dispensation>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
