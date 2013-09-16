package org.celllife.idart.domain.dispensation

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DispensationValidationException extends RuntimeException {

    Set<ConstraintViolation<Dispensation>> constraintViolations

    DispensationValidationException(Set<ConstraintViolation<Dispensation>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
