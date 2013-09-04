package org.celllife.idart.infrastructure.jsr303.unitofmeasure

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureValidationException
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureValidator
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
@Named class Jsr303UnitOfMeasureValidator implements UnitOfMeasureValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(UnitOfMeasure unitOfMeasure) {

        Set<ConstraintViolation<UnitOfMeasure>> constraintViolations = validatorFactory.validator.validate(unitOfMeasure)

        if (!constraintViolations.empty) {
            throw new UnitOfMeasureValidationException(constraintViolations)
        }
    }
}
