package org.celllife.idart.domain.product

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class ProductValidationException extends RuntimeException {

    Set<ConstraintViolation<Product>> constraintViolations

    ProductValidationException(Set<ConstraintViolation<Product>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
