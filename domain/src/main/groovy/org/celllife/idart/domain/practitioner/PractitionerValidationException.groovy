package org.celllife.idart.domain.practitioner

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PractitionerValidationException extends Exception {

    Set<ConstraintViolation<Practitioner>> constraintViolations

    PractitionerValidationException(Set<ConstraintViolation<Practitioner>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
