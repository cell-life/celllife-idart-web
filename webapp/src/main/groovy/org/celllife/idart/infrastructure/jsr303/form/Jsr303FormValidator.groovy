package org.celllife.idart.infrastructure.jsr303.form

import org.celllife.idart.domain.form.Form
import org.celllife.idart.domain.form.FormValidationException
import org.celllife.idart.domain.form.FormValidator
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
@Named class Jsr303FormValidator implements FormValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(Form form) {

        Set<ConstraintViolation<Form>> constraintViolations = validatorFactory.validator.validate(form)

        if (!constraintViolations.empty) {
            throw new FormValidationException(constraintViolations)
        }
    }
}
