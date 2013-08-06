package org.celllife.idart.domain.clinic

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class ClinicValidationException extends RuntimeException {

    Set<ConstraintViolation<Clinic>> constraintViolations

    ClinicValidationException(Set<ConstraintViolation<Clinic>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
