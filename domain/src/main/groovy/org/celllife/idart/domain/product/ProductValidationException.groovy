package org.celllife.idart.domain.product

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class ProductValidationException extends RuntimeException {

    Set<ConstraintViolation<Product>> constraintViolations

    ProductValidationException(Set<ConstraintViolation<Product>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
