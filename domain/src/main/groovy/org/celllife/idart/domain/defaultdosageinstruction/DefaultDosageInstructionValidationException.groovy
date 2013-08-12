package org.celllife.idart.domain.defaultdosageinstruction

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DefaultDosageInstructionValidationException extends Exception {

    Set<ConstraintViolation<DefaultDosageInstruction>> constraintViolations

    DefaultDosageInstructionValidationException(Set<ConstraintViolation<DefaultDosageInstruction>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
