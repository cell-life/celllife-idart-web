package org.celllife.idart.infrastructure.jsr303.encounter

import org.celllife.idart.domain.encounter.Encounter
import org.celllife.idart.domain.encounter.EncounterValidationException
import org.celllife.idart.domain.encounter.EncounterValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.inject.Inject
import javax.inject.Named
import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Named class Jsr303EncounterValidator implements EncounterValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(Encounter encounter) {

        Set<ConstraintViolation<Encounter>> constraintViolations = validatorFactory.validator.validate(encounter)

        if (!constraintViolations.empty) {
            throw new EncounterValidationException(constraintViolations)
        }
    }
}
