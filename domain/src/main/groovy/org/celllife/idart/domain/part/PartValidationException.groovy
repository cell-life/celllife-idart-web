package org.celllife.idart.domain.part

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PartValidationException extends RuntimeException {

    Set<ConstraintViolation<Part>> constraintViolations

    PartValidationException(Set<ConstraintViolation<Part>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
