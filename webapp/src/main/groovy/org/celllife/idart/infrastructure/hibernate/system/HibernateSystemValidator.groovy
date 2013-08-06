package org.celllife.idart.infrastructure.hibernate.system

import org.celllife.idart.domain.system.System
import org.celllife.idart.domain.system.SystemValidationException
import org.celllife.idart.domain.system.SystemValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Component class HibernateSystemValidator implements SystemValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(System system) throws SystemValidationException {

        Set<ConstraintViolation<System>> constraintViolations = validatorFactory.validator.validate(system)

        if (!constraintViolations.empty) {
            throw new SystemValidationException(constraintViolations)
        }
    }
}
