package org.celllife.idart.domain.encounter

import javax.validation.ConstraintViolation

/**
 */
class EncounterValidationException extends RuntimeException {

    Set<ConstraintViolation<Encounter>> constraintViolations

    EncounterValidationException(Set<ConstraintViolation<Encounter>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
