package org.celllife.idart.domain.facility

import javax.validation.ConstraintViolation

/**
 */
class FacilityValidationException extends RuntimeException {

    Set<ConstraintViolation<Facility>> constraintViolations

    FacilityValidationException(Set<ConstraintViolation<Facility>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
