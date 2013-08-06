package org.celllife.idart.infrastructure.validation.practitioner

import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.practitioner.PractitionerValidationException
import org.celllife.idart.domain.practitioner.PractitionerValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Component class HibernatePractitionerValidator implements PractitionerValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Practitioner practitioner) throws PractitionerValidationException {

        Set<ConstraintViolation<Practitioner>> constraintViolations = validatorFactory.validator.validate(practitioner)

        if (!constraintViolations.empty) {
            throw new PractitionerValidationException(constraintViolations)
        }
    }
}
