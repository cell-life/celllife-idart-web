package org.celllife.idart.domain.dispensedmedication

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DispensedMedicationValidationException extends RuntimeException {

    Set<ConstraintViolation<DispensedMedication>> constraintViolations

    DispensedMedicationValidationException(Set<ConstraintViolation<DispensedMedication>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
