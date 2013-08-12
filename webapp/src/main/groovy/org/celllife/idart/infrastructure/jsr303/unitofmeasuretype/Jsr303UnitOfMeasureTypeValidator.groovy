package org.celllife.idart.infrastructure.jsr303.unitofmeasuretype

import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureType
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeValidationException
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303UnitOfMeasureTypeValidator implements UnitOfMeasureTypeValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(UnitOfMeasureType unitOfMeasureType) throws UnitOfMeasureTypeValidationException {

        Set<ConstraintViolation<UnitOfMeasureType>> constraintViolations = validatorFactory.validator.validate(unitOfMeasureType)

        if (!constraintViolations.empty) {
            throw new UnitOfMeasureTypeValidationException(constraintViolations)
        }
    }
}
