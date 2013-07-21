package org.celllife.idart.domain.unitofmeasure

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UnitOfMeasureValidationException extends RuntimeException {

    Set<ConstraintViolation<UnitOfMeasure>> constraintViolations

    UnitOfMeasureValidationException(Set<ConstraintViolation<UnitOfMeasure>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
