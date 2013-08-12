package org.celllife.idart.infrastructure.jsr303.unitofmeasure

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureValidationException
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303UnitOfMeasureValidator implements UnitOfMeasureValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(UnitOfMeasure unitOfMeasure) throws UnitOfMeasureValidationException {

        Set<ConstraintViolation<UnitOfMeasure>> constraintViolations = validatorFactory.validator.validate(unitOfMeasure)

        if (!constraintViolations.empty) {
            throw new UnitOfMeasureValidationException(constraintViolations)
        }
    }
}
