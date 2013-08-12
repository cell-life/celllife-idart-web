package org.celllife.idart.infrastructure.jsr303.dispensation

import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.domain.dispensation.DispensationValidationException
import org.celllife.idart.domain.dispensation.DispensationValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303DispensationValidator implements DispensationValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Dispensation dispensation) throws DispensationValidationException {

        Set<ConstraintViolation<Dispensation>> constraintViolations = validatorFactory.validator.validate(dispensation)

        if (!constraintViolations.empty) {
            throw new DispensationValidationException(constraintViolations)
        }
    }
}
