package org.celllife.idart.domain.authority

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class AuthorityValidationException extends RuntimeException {

    Set<ConstraintViolation<Authority>> constraintViolations

    AuthorityValidationException(Set<ConstraintViolation<Authority>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
