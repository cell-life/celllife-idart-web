package org.celllife.idart.infrastructure.jsr303.defaultdosageinstruction

import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionValidationException
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionValidator
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
@Named class Jsr303DefaultDosageInstructionValidator implements DefaultDosageInstructionValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(DefaultDosageInstruction defaultDosageInstruction) {

        Set<ConstraintViolation<DefaultDosageInstruction>> constraintViolations = validatorFactory.validator.validate(defaultDosageInstruction)

        if (!constraintViolations.empty) {
            throw new DefaultDosageInstructionValidationException(constraintViolations)
        }
    }
}
