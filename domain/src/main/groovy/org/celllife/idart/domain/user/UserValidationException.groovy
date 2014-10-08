package org.celllife.idart.domain.user

import javax.validation.ConstraintViolation

/**
 */
class UserValidationException extends RuntimeException {

    UserValidationException(Set<ConstraintViolation<User>> constraintViolations) {
        super(constraintViolations);
    }
}
