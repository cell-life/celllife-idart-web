package org.celllife.idart.domain.administrationmethod

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class AdministrationMethodValidationException extends RuntimeException {

    Set<ConstraintViolation<AdministrationMethod>> constraintViolations

    AdministrationMethodValidationException(Set<ConstraintViolation<AdministrationMethod>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
