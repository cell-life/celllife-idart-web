package org.celllife.idart.domain.substitution

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SubstitutionValidationException extends RuntimeException {

    Set<ConstraintViolation<Substitution>> constraintViolations

    SubstitutionValidationException(Set<ConstraintViolation<Substitution>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
