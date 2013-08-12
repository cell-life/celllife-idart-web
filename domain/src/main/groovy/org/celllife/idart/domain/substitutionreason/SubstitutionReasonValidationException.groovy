package org.celllife.idart.domain.substitutionreason

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SubstitutionReasonValidationException extends Exception {

    Set<ConstraintViolation<SubstitutionReason>> constraintViolations

    SubstitutionReasonValidationException(Set<ConstraintViolation<SubstitutionReason>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
