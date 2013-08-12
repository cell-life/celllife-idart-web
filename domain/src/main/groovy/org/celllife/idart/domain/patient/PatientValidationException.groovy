package org.celllife.idart.domain.patient

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PatientValidationException extends Exception {

    Set<ConstraintViolation<Patient>> constraintViolations

    PatientValidationException(Set<ConstraintViolation<Patient>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
