package org.celllife.idart.domain.system

import javax.validation.ConstraintViolation

/**
 */
class SystemValidationException extends RuntimeException {

    Set<ConstraintViolation<System>> constraintViolations

    SystemValidationException(Set<ConstraintViolation<System>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
