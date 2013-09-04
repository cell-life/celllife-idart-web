package org.celllife.idart.infrastructure.jsr303.indication

import org.celllife.idart.domain.indication.Indication
import org.celllife.idart.domain.indication.IndicationValidationException
import org.celllife.idart.domain.indication.IndicationValidator
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
@Named class Jsr303IndicationValidator implements IndicationValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(Indication indication) {

        Set<ConstraintViolation<Indication>> constraintViolations = validatorFactory.validator.validate(indication)

        if (!constraintViolations.empty) {
            throw new IndicationValidationException(constraintViolations)
        }
    }
}
