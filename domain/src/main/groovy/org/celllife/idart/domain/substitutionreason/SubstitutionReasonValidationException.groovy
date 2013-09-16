package org.celllife.idart.domain.substitutionreason

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SubstitutionReasonValidationException extends RuntimeException {

    Set<ConstraintViolation<SubstitutionReason>> constraintViolations

    SubstitutionReasonValidationException(Set<ConstraintViolation<SubstitutionReason>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
