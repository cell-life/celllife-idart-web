package org.celllife.idart.domain.part

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PartValidationException extends RuntimeException {

    Set<ConstraintViolation<Part>> constraintViolations

    PartValidationException(Set<ConstraintViolation<Part>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
