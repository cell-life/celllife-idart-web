package org.celllife.idart.domain.practitioner

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PractitionerValidationException extends RuntimeException {

    Set<ConstraintViolation<Practitioner>> constraintViolations

    PractitionerValidationException(Set<ConstraintViolation<Practitioner>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
