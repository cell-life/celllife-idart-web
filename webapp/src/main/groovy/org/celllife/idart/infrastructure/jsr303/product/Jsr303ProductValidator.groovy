package org.celllife.idart.infrastructure.jsr303.product

import org.celllife.idart.domain.product.Product
import org.celllife.idart.domain.product.ProductValidationException
import org.celllife.idart.domain.product.ProductValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.inject.Inject
import javax.inject.Named
import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Named class Jsr303ProductValidator implements ProductValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(Product product) {

        Set<ConstraintViolation<Product>> constraintViolations = validatorFactory.validator.validate(product)

        if (!constraintViolations.empty) {
            throw new ProductValidationException(constraintViolations)
        }
    }
}
