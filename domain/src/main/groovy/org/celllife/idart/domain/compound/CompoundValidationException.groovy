package org.celllife.idart.domain.compound

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class CompoundValidationException extends Exception {

    Set<ConstraintViolation<Compound>> constraintViolations

    CompoundValidationException(Set<ConstraintViolation<Compound>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
