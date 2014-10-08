package org.celllife.idart.domain.organisation

import javax.validation.ConstraintViolation

import org.celllife.idart.domain.exception.ValidationException

/**
 */
class OrganisationValidationException extends ValidationException {

    OrganisationValidationException(Set<ConstraintViolation<Organisation>> constraintViolations) {
        super(constraintViolations);
    }
}
