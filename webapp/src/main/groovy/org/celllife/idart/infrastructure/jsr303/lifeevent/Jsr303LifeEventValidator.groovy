package org.celllife.idart.infrastructure.jsr303.lifeevent

import org.celllife.idart.domain.lifeevent.LifeEvent
import org.celllife.idart.domain.lifeevent.LifeEventValidationException
import org.celllife.idart.domain.lifeevent.LifeEventValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303LifeEventValidator implements LifeEventValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(LifeEvent lifeEvent) throws LifeEventValidationException {

        Set<ConstraintViolation<LifeEvent>> constraintViolations = validatorFactory.validator.validate(lifeEvent)

        if (!constraintViolations.empty) {
            throw new LifeEventValidationException(constraintViolations)
        }
    }
}
