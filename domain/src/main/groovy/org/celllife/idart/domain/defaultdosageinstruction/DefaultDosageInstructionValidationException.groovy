package org.celllife.idart.domain.defaultdosageinstruction

import javax.validation.ConstraintViolation

import org.celllife.idart.domain.exception.ValidationException

/**
 */
class DefaultDosageInstructionValidationException extends ValidationException {

    DefaultDosageInstructionValidationException(Set<ConstraintViolation<DefaultDosageInstruction>> constraintViolations) {
        super(constraintViolations);
    }
}
