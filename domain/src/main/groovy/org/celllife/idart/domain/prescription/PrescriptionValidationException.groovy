package org.celllife.idart.domain.prescription

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PrescriptionValidationException extends RuntimeException {

    Set<ConstraintViolation<Prescription>> constraintViolations

    PrescriptionValidationException(Set<ConstraintViolation<Prescription>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
