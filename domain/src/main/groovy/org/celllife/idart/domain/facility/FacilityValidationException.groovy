package org.celllife.idart.domain.facility

import javax.validation.ConstraintViolation

import org.celllife.idart.domain.exception.ValidationException

/**
 */
class FacilityValidationException extends ValidationException {

    FacilityValidationException(Set<ConstraintViolation<Facility>> constraintViolations) {
        super(constraintViolations);
    }
}
