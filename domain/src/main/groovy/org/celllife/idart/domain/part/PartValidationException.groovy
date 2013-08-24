package org.celllife.idart.domain.part

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PartValidationException extends Exception {

    Set<ConstraintViolation<Part>> constraintViolations

    PartValidationException(Set<ConstraintViolation<Part>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
