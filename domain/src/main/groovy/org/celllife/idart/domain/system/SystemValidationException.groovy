package org.celllife.idart.domain.system

import javax.validation.ConstraintViolation

/**
 */
class SystemValidationException extends RuntimeException {

    SystemValidationException(Set<ConstraintViolation<System>> constraintViolations) {
        super(constraintViolations);
    }
}
