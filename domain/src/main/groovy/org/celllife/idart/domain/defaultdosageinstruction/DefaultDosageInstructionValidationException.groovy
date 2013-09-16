package org.celllife.idart.domain.defaultdosageinstruction

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DefaultDosageInstructionValidationException extends RuntimeException {

    Set<ConstraintViolation<DefaultDosageInstruction>> constraintViolations

    DefaultDosageInstructionValidationException(Set<ConstraintViolation<DefaultDosageInstruction>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
