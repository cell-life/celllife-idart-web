package org.celllife.idart.domain.patient

import javax.validation.ConstraintViolation

import org.celllife.idart.domain.exception.ValidationException

/**
 */
class PatientValidationException extends ValidationException {

    PatientValidationException(Set<ConstraintViolation<Patient>> constraintViolations) {
        super(constraintViolations);
    }
}
