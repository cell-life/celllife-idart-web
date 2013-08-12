package org.celllife.idart.infrastructure.jsr303.form

import org.celllife.idart.domain.form.Form
import org.celllife.idart.domain.form.FormValidationException
import org.celllife.idart.domain.form.FormValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303FormValidator implements FormValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Form form) throws FormValidationException {

        Set<ConstraintViolation<Form>> constraintViolations = validatorFactory.validator.validate(form)

        if (!constraintViolations.empty) {
            throw new FormValidationException(constraintViolations)
        }
    }
}
