package org.celllife.idart.infrastructure.hibernate.form

import org.celllife.idart.domain.form.Form
import org.celllife.idart.domain.form.FormValidationException
import org.celllife.idart.domain.form.FormValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Component class HibernateFormValidator implements FormValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Form form) throws FormValidationException {

        Set<ConstraintViolation<Form>> constraintViolations = validatorFactory.validator.validate(form)

        if (!constraintViolations.empty) {
            throw new FormValidationException(constraintViolations)
        }
    }
}
