package org.celllife.idart.domain.medication

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class MedicationValidationException extends Exception {

    Set<ConstraintViolation<Medication>> constraintViolations

    MedicationValidationException(Set<ConstraintViolation<Medication>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
