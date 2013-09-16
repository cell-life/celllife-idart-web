package org.celllife.idart.domain.system

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SystemValidationException extends RuntimeException {

    Set<ConstraintViolation<System>> constraintViolations

    SystemValidationException(Set<ConstraintViolation<System>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
