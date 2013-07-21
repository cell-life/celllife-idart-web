package org.celllife.idart.domain.form

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class FormValidationException extends RuntimeException {

    Set<ConstraintViolation<Form>> constraintViolations

    FormValidationException(Set<ConstraintViolation<Form>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
