package org.celllife.idart.domain.entrysite

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EntrySiteValidationException extends RuntimeException {

    Set<ConstraintViolation<EntrySite>> constraintViolations

    EntrySiteValidationException(Set<ConstraintViolation<EntrySite>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
