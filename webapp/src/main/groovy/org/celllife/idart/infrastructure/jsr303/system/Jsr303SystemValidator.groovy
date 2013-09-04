package org.celllife.idart.infrastructure.jsr303.system

import org.celllife.idart.domain.system.System
import org.celllife.idart.domain.system.SystemValidationException
import org.celllife.idart.domain.system.SystemValidator
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
@Named class Jsr303SystemValidator implements SystemValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(System system) {

        Set<ConstraintViolation<System>> constraintViolations = validatorFactory.validator.validate(system)

        if (!constraintViolations.empty) {
            throw new SystemValidationException(constraintViolations)
        }
    }
}
