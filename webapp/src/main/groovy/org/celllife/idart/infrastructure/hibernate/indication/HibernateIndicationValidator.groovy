package org.celllife.idart.infrastructure.hibernate.indication

import org.celllife.idart.domain.indication.Indication
import org.celllife.idart.domain.indication.IndicationValidationException
import org.celllife.idart.domain.indication.IndicationValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Component class HibernateIndicationValidator implements IndicationValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Indication indication) throws IndicationValidationException {

        Set<ConstraintViolation<Indication>> constraintViolations = validatorFactory.validator.validate(indication)

        if (!constraintViolations.empty) {
            throw new IndicationValidationException(constraintViolations)
        }
    }
}
