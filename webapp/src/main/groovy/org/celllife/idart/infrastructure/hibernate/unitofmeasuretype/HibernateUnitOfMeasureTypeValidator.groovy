package org.celllife.idart.infrastructure.hibernate.unitofmeasuretype

import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureType
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeValidationException
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Component class HibernateUnitOfMeasureTypeValidator implements UnitOfMeasureTypeValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(UnitOfMeasureType unitOfMeasureType) throws UnitOfMeasureTypeValidationException {

        Set<ConstraintViolation<UnitOfMeasureType>> constraintViolations = validatorFactory.validator.validate(unitOfMeasureType)

        if (!constraintViolations.empty) {
            throw new UnitOfMeasureTypeValidationException(constraintViolations)
        }
    }
}
