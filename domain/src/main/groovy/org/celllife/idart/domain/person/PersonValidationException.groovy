package org.celllife.idart.domain.person

import javax.validation.ConstraintViolation

import org.celllife.idart.domain.exception.ValidationException

/**
 */
class PersonValidationException extends ValidationException {

    PersonValidationException(Set<ConstraintViolation<Person>> constraintViolations) {
        super(constraintViolations);
    }
}
