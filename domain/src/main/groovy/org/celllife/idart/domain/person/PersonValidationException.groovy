package org.celllife.idart.domain.person

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PersonValidationException extends RuntimeException {

    Set<ConstraintViolation<Person>> constraintViolations

    PersonValidationException(Set<ConstraintViolation<Person>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
