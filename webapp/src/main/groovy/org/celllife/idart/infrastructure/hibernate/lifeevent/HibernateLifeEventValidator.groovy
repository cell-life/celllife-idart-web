package org.celllife.idart.infrastructure.hibernate.lifeevent

import org.celllife.idart.domain.lifeevent.LifeEvent
import org.celllife.idart.domain.lifeevent.LifeEventValidationException
import org.celllife.idart.domain.lifeevent.LifeEventValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Component class HibernateLifeEventValidator implements LifeEventValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(LifeEvent lifeEvent) throws LifeEventValidationException {

        Set<ConstraintViolation<LifeEvent>> constraintViolations = validatorFactory.validator.validate(lifeEvent)

        if (!constraintViolations.empty) {
            throw new LifeEventValidationException(constraintViolations)
        }
    }
}
