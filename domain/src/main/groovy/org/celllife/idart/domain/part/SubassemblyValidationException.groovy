package org.celllife.idart.domain.part

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SubassemblyValidationException extends RuntimeException {

    Set<ConstraintViolation<Subassembly>> constraintViolations

    SubassemblyValidationException(Set<ConstraintViolation<Subassembly>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
