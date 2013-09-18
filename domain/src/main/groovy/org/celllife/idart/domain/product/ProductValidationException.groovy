package org.celllife.idart.domain.product

import javax.validation.ConstraintViolation

/**
 */
class ProductValidationException extends RuntimeException {

    Set<ConstraintViolation<Product>> constraintViolations

    ProductValidationException(Set<ConstraintViolation<Product>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
