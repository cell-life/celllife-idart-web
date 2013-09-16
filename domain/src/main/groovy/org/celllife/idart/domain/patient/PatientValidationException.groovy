package org.celllife.idart.domain.patient

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PatientValidationException extends RuntimeException {

    Set<ConstraintViolation<Patient>> constraintViolations

    PatientValidationException(Set<ConstraintViolation<Patient>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
