package org.celllife.idart.domain.practitioner

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PractitionerValidationException extends RuntimeException {

    Set<ConstraintViolation<Practitioner>> constraintViolations

    PractitionerValidationException(Set<ConstraintViolation<Practitioner>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
