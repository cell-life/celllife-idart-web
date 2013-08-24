package org.celllife.idart.infrastructure.jsr303.part

import org.celllife.idart.domain.part.Part
import org.celllife.idart.domain.part.PartValidationException
import org.celllife.idart.domain.part.PartValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303PartValidator implements PartValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Part part) throws PartValidationException {

        Set<ConstraintViolation<Part>> constraintViolations = validatorFactory.validator.validate(part)

        if (!constraintViolations.empty) {
            throw new PartValidationException(constraintViolations)
        }
    }
}
