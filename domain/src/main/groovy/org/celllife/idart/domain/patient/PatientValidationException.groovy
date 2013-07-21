package org.celllife.idart.domain.patient

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PatientValidationException extends RuntimeException {

    Set<ConstraintViolation<Patient>> constraintViolations

    PatientValidationException(Set<ConstraintViolation<Patient>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
