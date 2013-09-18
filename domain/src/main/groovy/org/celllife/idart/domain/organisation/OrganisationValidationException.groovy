package org.celllife.idart.domain.organisation

import javax.validation.ConstraintViolation

/**
 */
class OrganisationValidationException extends RuntimeException {

    Set<ConstraintViolation<Organisation>> constraintViolations

    OrganisationValidationException(Set<ConstraintViolation<Organisation>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
