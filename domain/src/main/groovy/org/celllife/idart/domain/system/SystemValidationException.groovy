package org.celllife.idart.domain.system

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SystemValidationException extends RuntimeException {

    Set<ConstraintViolation<System>> constraintViolations

    SystemValidationException(Set<ConstraintViolation<System>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
