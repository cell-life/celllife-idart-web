package org.celllife.idart.domain.organisation

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class OrganisationValidationException extends RuntimeException {

    Set<ConstraintViolation<Organisation>> constraintViolations

    OrganisationValidationException(Set<ConstraintViolation<Organisation>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
