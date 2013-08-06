package org.celllife.idart.domain.encounter

import javax.validation.ConstraintViolation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EncounterValidationException extends RuntimeException {

    Set<ConstraintViolation<Encounter>> constraintViolations

    EncounterValidationException(Set<ConstraintViolation<Encounter>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
