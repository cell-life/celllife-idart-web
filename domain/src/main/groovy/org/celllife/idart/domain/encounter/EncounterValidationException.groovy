package org.celllife.idart.domain.encounter

import javax.annotation.Generated
import javax.validation.ConstraintViolation

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EncounterValidationException extends RuntimeException {

    Set<ConstraintViolation<Encounter>> constraintViolations

    EncounterValidationException(Set<ConstraintViolation<Encounter>> constraintViolations) {
        this.constraintViolations = constraintViolations
    }
}
