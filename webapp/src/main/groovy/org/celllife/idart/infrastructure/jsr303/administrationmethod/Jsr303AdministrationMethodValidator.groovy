package org.celllife.idart.infrastructure.jsr303.administrationmethod

import org.celllife.idart.domain.administrationmethod.AdministrationMethod
import org.celllife.idart.domain.administrationmethod.AdministrationMethodValidationException
import org.celllife.idart.domain.administrationmethod.AdministrationMethodValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303AdministrationMethodValidator implements AdministrationMethodValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(AdministrationMethod administrationMethod) throws AdministrationMethodValidationException {

        Set<ConstraintViolation<AdministrationMethod>> constraintViolations = validatorFactory.validator.validate(administrationMethod)

        if (!constraintViolations.empty) {
            throw new AdministrationMethodValidationException(constraintViolations)
        }
    }
}
