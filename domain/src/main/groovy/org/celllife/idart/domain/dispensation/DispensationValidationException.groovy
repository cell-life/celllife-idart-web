package org.celllife.idart.domain.dispensation

import javax.validation.ConstraintViolation

import org.celllife.idart.domain.exception.ValidationException

/**
 */
class DispensationValidationException extends ValidationException {

    DispensationValidationException(Set<ConstraintViolation<Dispensation>> constraintViolations) {
        super(constraintViolations);
    }
}
