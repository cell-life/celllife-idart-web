package org.celllife.idart.domain.product

import javax.validation.ConstraintViolation

/**
 */
class ProductValidationException extends RuntimeException {

    ProductValidationException(Set<ConstraintViolation<Product>> constraintViolations) {
        super(constraintViolations);
    }
}
