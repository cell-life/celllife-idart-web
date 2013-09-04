package org.celllife.idart.domain.unitofmeasure

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UnitOfMeasureValidationException extends RuntimeException {

    Set<ConstraintViolation<UnitOfMeasure>> constraintViolations

    UnitOfMeasureValidationException(Set<ConstraintViolation<UnitOfMeasure>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
