package org.celllife.idart.domain.facility

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class FacilityValidationException extends RuntimeException {

    Set<ConstraintViolation<Facility>> constraintViolations

    FacilityValidationException(Set<ConstraintViolation<Facility>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
