package org.celllife.idart.domain.part

import javax.validation.ConstraintViolation

import org.celllife.idart.domain.exception.ValidationException

/**
 */
class PartValidationException extends ValidationException {

    PartValidationException(Set<ConstraintViolation<Part>> constraintViolations) {
        super(constraintViolations);
    }
}
