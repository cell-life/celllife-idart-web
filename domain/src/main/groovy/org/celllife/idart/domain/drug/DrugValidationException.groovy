package org.celllife.idart.domain.drug

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DrugValidationException extends Exception {

    Set<ConstraintViolation<Drug>> constraintViolations

    DrugValidationException(Set<ConstraintViolation<Drug>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
