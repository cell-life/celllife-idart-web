package org.celllife.idart.infrastructure.jsr303.lifeevent

import org.celllife.idart.domain.lifeevent.LifeEvent
import org.celllife.idart.domain.lifeevent.LifeEventValidationException
import org.celllife.idart.domain.lifeevent.LifeEventValidator
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
@Named class Jsr303LifeEventValidator implements LifeEventValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(LifeEvent lifeEvent) {

        Set<ConstraintViolation<LifeEvent>> constraintViolations = validatorFactory.validator.validate(lifeEvent)

        if (!constraintViolations.empty) {
            throw new LifeEventValidationException(constraintViolations)
        }
    }
}
