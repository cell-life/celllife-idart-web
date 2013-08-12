package org.celllife.idart.domain.facility

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class FacilityValidationException extends Exception {

    Set<ConstraintViolation<Facility>> constraintViolations

    FacilityValidationException(Set<ConstraintViolation<Facility>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
