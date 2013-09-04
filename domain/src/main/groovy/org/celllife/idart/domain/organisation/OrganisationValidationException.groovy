package org.celllife.idart.domain.organisation

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class OrganisationValidationException extends RuntimeException {

    Set<ConstraintViolation<Organisation>> constraintViolations

    OrganisationValidationException(Set<ConstraintViolation<Organisation>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
