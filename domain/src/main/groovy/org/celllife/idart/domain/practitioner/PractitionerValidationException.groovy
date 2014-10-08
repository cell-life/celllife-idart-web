package org.celllife.idart.domain.practitioner

import javax.validation.ConstraintViolation

import org.celllife.idart.domain.exception.ValidationException

/**
 */
class PractitionerValidationException extends ValidationException {

    PractitionerValidationException(Set<ConstraintViolation<Practitioner>> constraintViolations) {
        super(constraintViolations);
    }
}
