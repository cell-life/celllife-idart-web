package org.celllife.idart.infrastructure.jsr303.dispensation

import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.domain.dispensation.DispensationValidationException
import org.celllife.idart.domain.dispensation.DispensationValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.inject.Inject
import javax.inject.Named
import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Named class Jsr303DispensationValidator implements DispensationValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(Dispensation dispensation) {

        Set<ConstraintViolation<Dispensation>> constraintViolations = validatorFactory.validator.validate(dispensation)

        if (!constraintViolations.empty) {
            throw new DispensationValidationException(constraintViolations)
        }
    }
}
