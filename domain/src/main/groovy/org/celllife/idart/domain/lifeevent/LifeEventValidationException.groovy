package org.celllife.idart.domain.lifeevent

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class LifeEventValidationException extends Exception {

    Set<ConstraintViolation<LifeEvent>> constraintViolations

    LifeEventValidationException(Set<ConstraintViolation<LifeEvent>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
