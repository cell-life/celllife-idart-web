package org.celllife.idart.domain.indication

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class IndicationValidationException extends RuntimeException {

    Set<ConstraintViolation<Indication>> constraintViolations

    IndicationValidationException(Set<ConstraintViolation<Indication>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
