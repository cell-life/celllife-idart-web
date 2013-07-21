package org.celllife.idart.domain.prescription

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PrescriptionValidationException extends RuntimeException {

    Set<ConstraintViolation<Prescription>> constraintViolations

    PrescriptionValidationException(Set<ConstraintViolation<Prescription>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
