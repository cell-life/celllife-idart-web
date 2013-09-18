package org.celllife.idart.domain.user

import javax.validation.ConstraintViolation

/**
 */
class UserValidationException extends RuntimeException {

    Set<ConstraintViolation<User>> constraintViolations

    UserValidationException(Set<ConstraintViolation<User>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
