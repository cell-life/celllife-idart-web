package org.celllife.idart.infrastructure.jsr303.compound

import org.celllife.idart.domain.compound.Compound
import org.celllife.idart.domain.compound.CompoundValidationException
import org.celllife.idart.domain.compound.CompoundValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303CompoundValidator implements CompoundValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Compound compound) throws CompoundValidationException {

        Set<ConstraintViolation<Compound>> constraintViolations = validatorFactory.validator.validate(compound)

        if (!constraintViolations.empty) {
            throw new CompoundValidationException(constraintViolations)
        }
    }
}
