package org.celllife.idart.domain.patient

import javax.validation.ConstraintViolation

/**
 */
class PatientValidationException extends RuntimeException {

    Set<ConstraintViolation<Patient>> constraintViolations

    PatientValidationException(Set<ConstraintViolation<Patient>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
