package org.celllife.idart.domain.lifeevent

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class LifeEventValidationException extends RuntimeException {

    Set<ConstraintViolation<LifeEvent>> constraintViolations

    LifeEventValidationException(Set<ConstraintViolation<LifeEvent>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
