package org.celllife.idart.infrastructure.validation.part

import org.celllife.idart.domain.part.Part
import org.celllife.idart.domain.part.PartValidationException
import org.celllife.idart.domain.part.PartValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Component class HibernatePartValidator implements PartValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Part part) throws PartValidationException {

        Set<ConstraintViolation<Part>> constraintViolations = validatorFactory.validator.validate(part)

        if (!constraintViolations.empty) {
            throw new PartValidationException(constraintViolations)
        }
    }
}
