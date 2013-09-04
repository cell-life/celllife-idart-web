package org.celllife.idart.domain.unitofmeasuretype

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UnitOfMeasureTypeValidationException extends RuntimeException {

    Set<ConstraintViolation<UnitOfMeasureType>> constraintViolations

    UnitOfMeasureTypeValidationException(Set<ConstraintViolation<UnitOfMeasureType>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
