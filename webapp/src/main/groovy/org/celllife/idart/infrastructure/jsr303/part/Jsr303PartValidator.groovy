package org.celllife.idart.infrastructure.jsr303.part

import org.celllife.idart.domain.part.Part
import org.celllife.idart.domain.part.PartValidationException
import org.celllife.idart.domain.part.PartValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.inject.Inject
import javax.inject.Named
import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Named class Jsr303PartValidator implements PartValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(Part part) {

        Set<ConstraintViolation<Part>> constraintViolations = validatorFactory.validator.validate(part)

        if (!constraintViolations.empty) {
            throw new PartValidationException(constraintViolations)
        }
    }
}
