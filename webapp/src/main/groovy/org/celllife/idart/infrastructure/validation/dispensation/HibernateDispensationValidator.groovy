package org.celllife.idart.infrastructure.validation.dispensation

import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.domain.dispensation.DispensationValidationException
import org.celllife.idart.domain.dispensation.DispensationValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Component class HibernateDispensationValidator implements DispensationValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Dispensation dispensation) throws DispensationValidationException {

        Set<ConstraintViolation<Dispensation>> constraintViolations = validatorFactory.validator.validate(dispensation)

        if (!constraintViolations.empty) {
            throw new DispensationValidationException(constraintViolations)
        }
    }
}
