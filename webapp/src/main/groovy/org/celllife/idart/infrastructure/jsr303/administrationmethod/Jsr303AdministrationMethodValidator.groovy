package org.celllife.idart.infrastructure.jsr303.administrationmethod

import org.celllife.idart.domain.administrationmethod.AdministrationMethod
import org.celllife.idart.domain.administrationmethod.AdministrationMethodValidationException
import org.celllife.idart.domain.administrationmethod.AdministrationMethodValidator
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
@Named class Jsr303AdministrationMethodValidator implements AdministrationMethodValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(AdministrationMethod administrationMethod) {

        Set<ConstraintViolation<AdministrationMethod>> constraintViolations = validatorFactory.validator.validate(administrationMethod)

        if (!constraintViolations.empty) {
            throw new AdministrationMethodValidationException(constraintViolations)
        }
    }
}
