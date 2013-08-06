package org.celllife.idart.domain.dispensation

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DispensationValidationException extends RuntimeException {

    Set<ConstraintViolation<Dispensation>> constraintViolations

    DispensationValidationException(Set<ConstraintViolation<Dispensation>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
