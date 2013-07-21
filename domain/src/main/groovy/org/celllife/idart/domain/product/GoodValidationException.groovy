package org.celllife.idart.domain.product

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class GoodValidationException extends RuntimeException {

    Set<ConstraintViolation<Good>> constraintViolations

    GoodValidationException(Set<ConstraintViolation<Good>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
