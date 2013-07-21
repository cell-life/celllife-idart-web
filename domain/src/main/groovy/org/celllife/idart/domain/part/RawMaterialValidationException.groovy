package org.celllife.idart.domain.part

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class RawMaterialValidationException extends RuntimeException {

    Set<ConstraintViolation<RawMaterial>> constraintViolations

    RawMaterialValidationException(Set<ConstraintViolation<RawMaterial>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
