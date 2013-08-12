package org.celllife.idart.infrastructure.jsr303.system

import org.celllife.idart.domain.system.System
import org.celllife.idart.domain.system.SystemValidationException
import org.celllife.idart.domain.system.SystemValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303SystemValidator implements SystemValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(System system) throws SystemValidationException {

        Set<ConstraintViolation<System>> constraintViolations = validatorFactory.validator.validate(system)

        if (!constraintViolations.empty) {
            throw new SystemValidationException(constraintViolations)
        }
    }
}
