package org.celllife.idart.domain.administrationmethod

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class AdministrationMethodValidationException extends RuntimeException {

    Set<ConstraintViolation<AdministrationMethod>> constraintViolations

    AdministrationMethodValidationException(Set<ConstraintViolation<AdministrationMethod>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
