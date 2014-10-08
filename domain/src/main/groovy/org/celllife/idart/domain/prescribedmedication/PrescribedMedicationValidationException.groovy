package org.celllife.idart.domain.prescribedmedication

import javax.validation.ConstraintViolation

import org.celllife.idart.domain.exception.ValidationException

/**
 */
class PrescribedMedicationValidationException extends ValidationException {

    PrescribedMedicationValidationException(Set<ConstraintViolation<PrescribedMedication>> constraintViolations) {
        super(constraintViolations);
    }
}
