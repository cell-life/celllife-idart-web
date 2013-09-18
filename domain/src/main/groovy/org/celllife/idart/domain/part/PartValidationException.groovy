package org.celllife.idart.domain.part

import javax.validation.ConstraintViolation

/**
 */
class PartValidationException extends RuntimeException {

    Set<ConstraintViolation<Part>> constraintViolations

    PartValidationException(Set<ConstraintViolation<Part>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
