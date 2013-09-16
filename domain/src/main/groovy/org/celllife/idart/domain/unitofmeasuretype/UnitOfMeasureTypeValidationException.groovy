package org.celllife.idart.domain.unitofmeasuretype

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UnitOfMeasureTypeValidationException extends RuntimeException {

    Set<ConstraintViolation<UnitOfMeasureType>> constraintViolations

    UnitOfMeasureTypeValidationException(Set<ConstraintViolation<UnitOfMeasureType>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
