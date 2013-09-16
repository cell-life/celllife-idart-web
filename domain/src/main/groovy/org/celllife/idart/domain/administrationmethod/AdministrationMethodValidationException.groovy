package org.celllife.idart.domain.administrationmethod

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class AdministrationMethodValidationException extends RuntimeException {

    Set<ConstraintViolation<AdministrationMethod>> constraintViolations

    AdministrationMethodValidationException(Set<ConstraintViolation<AdministrationMethod>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
