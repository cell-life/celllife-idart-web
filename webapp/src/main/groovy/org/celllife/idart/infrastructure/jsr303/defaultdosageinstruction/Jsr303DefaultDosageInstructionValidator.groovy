package org.celllife.idart.infrastructure.jsr303.defaultdosageinstruction

import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionValidationException
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303DefaultDosageInstructionValidator implements DefaultDosageInstructionValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(DefaultDosageInstruction defaultDosageInstruction) throws DefaultDosageInstructionValidationException {

        Set<ConstraintViolation<DefaultDosageInstruction>> constraintViolations = validatorFactory.validator.validate(defaultDosageInstruction)

        if (!constraintViolations.empty) {
            throw new DefaultDosageInstructionValidationException(constraintViolations)
        }
    }
}
