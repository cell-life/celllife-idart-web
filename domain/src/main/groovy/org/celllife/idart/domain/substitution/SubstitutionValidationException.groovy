package org.celllife.idart.domain.substitution

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SubstitutionValidationException extends Exception {

    Set<ConstraintViolation<Substitution>> constraintViolations

    SubstitutionValidationException(Set<ConstraintViolation<Substitution>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
