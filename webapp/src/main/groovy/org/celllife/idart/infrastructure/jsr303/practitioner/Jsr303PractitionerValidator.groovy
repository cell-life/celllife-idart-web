package org.celllife.idart.infrastructure.jsr303.practitioner

import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.practitioner.PractitionerValidationException
import org.celllife.idart.domain.practitioner.PractitionerValidator
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
@Named class Jsr303PractitionerValidator implements PractitionerValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(Practitioner practitioner) {

        Set<ConstraintViolation<Practitioner>> constraintViolations = validatorFactory.validator.validate(practitioner)

        if (!constraintViolations.empty) {
            throw new PractitionerValidationException(constraintViolations)
        }
    }
}
