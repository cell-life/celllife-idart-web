package org.celllife.idart.domain.part

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class CompoundValidationException extends RuntimeException {

    Set<ConstraintViolation<Compound>> constraintViolations

    CompoundValidationException(Set<ConstraintViolation<Compound>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
