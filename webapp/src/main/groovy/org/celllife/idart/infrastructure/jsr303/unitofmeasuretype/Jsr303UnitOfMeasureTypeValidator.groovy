package org.celllife.idart.infrastructure.jsr303.unitofmeasuretype

import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureType
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeValidationException
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class Jsr303UnitOfMeasureTypeValidator implements UnitOfMeasureTypeValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(UnitOfMeasureType unitOfMeasureType) {

        Set<ConstraintViolation<UnitOfMeasureType>> constraintViolations = validatorFactory.validator.validate(unitOfMeasureType)

        if (!constraintViolations.empty) {
            throw new UnitOfMeasureTypeValidationException(constraintViolations)
        }
    }
}
