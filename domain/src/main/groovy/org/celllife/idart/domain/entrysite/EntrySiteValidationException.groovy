package org.celllife.idart.domain.entrysite

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EntrySiteValidationException extends Exception {

    Set<ConstraintViolation<EntrySite>> constraintViolations

    EntrySiteValidationException(Set<ConstraintViolation<EntrySite>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
