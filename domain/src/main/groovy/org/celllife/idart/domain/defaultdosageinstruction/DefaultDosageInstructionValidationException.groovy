package org.celllife.idart.domain.defaultdosageinstruction

import javax.validation.ConstraintViolation

/**
 */
class DefaultDosageInstructionValidationException extends RuntimeException {

    Set<ConstraintViolation<DefaultDosageInstruction>> constraintViolations

    DefaultDosageInstructionValidationException(Set<ConstraintViolation<DefaultDosageInstruction>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
