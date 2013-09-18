package org.celllife.idart.domain.person

import javax.validation.ConstraintViolation

/**
 */
class PersonValidationException extends RuntimeException {

    Set<ConstraintViolation<Person>> constraintViolations

    PersonValidationException(Set<ConstraintViolation<Person>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
