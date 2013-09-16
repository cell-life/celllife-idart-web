package org.celllife.idart.domain.form

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class FormValidationException extends RuntimeException {

    Set<ConstraintViolation<Form>> constraintViolations

    FormValidationException(Set<ConstraintViolation<Form>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
