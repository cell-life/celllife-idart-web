package org.celllife.idart.domain.encounter

import javax.validation.ConstraintViolation

import org.celllife.idart.domain.exception.ValidationException

/**
 */
class EncounterValidationException extends ValidationException {

    EncounterValidationException(Set<ConstraintViolation<Encounter>> constraintViolations) {
        super(constraintViolations);
    }
}
