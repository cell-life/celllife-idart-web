package org.celllife.idart.domain.practitioner

import javax.validation.ConstraintViolation

/**
 */
class PractitionerValidationException extends RuntimeException {

    Set<ConstraintViolation<Practitioner>> constraintViolations

    PractitionerValidationException(Set<ConstraintViolation<Practitioner>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
