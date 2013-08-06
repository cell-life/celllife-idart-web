package org.celllife.idart.domain.indication

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class IndicationValidationException extends Exception {

    Set<ConstraintViolation<Indication>> constraintViolations

    IndicationValidationException(Set<ConstraintViolation<Indication>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
