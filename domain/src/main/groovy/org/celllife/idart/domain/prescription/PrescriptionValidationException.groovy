package org.celllife.idart.domain.prescription

import javax.validation.ConstraintViolation

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 19h17
 */
class PrescriptionValidationException extends RuntimeException {

    Set<ConstraintViolation<Prescription>> constraintViolations

    PrescriptionValidationException(Set<ConstraintViolation<Prescription>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
