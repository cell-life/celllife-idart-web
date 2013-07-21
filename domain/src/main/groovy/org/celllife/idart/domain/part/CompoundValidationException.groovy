package org.celllife.idart.domain.part

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class CompoundValidationException extends RuntimeException {

    Set<ConstraintViolation<Compound>> constraintViolations

    CompoundValidationException(Set<ConstraintViolation<Compound>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
