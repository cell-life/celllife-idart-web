package org.celllife.idart.domain.user

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UserValidationException extends RuntimeException {

    Set<ConstraintViolation<User>> constraintViolations

    UserValidationException(Set<ConstraintViolation<User>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
