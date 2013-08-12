package org.celllife.idart.domain.form

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class FormValidationException extends Exception {

    Set<ConstraintViolation<Form>> constraintViolations

    FormValidationException(Set<ConstraintViolation<Form>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
