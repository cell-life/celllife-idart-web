package org.celllife.idart.infrastructure.validation.encounter

import org.celllife.idart.domain.encounter.Encounter
import org.celllife.idart.domain.encounter.EncounterValidationException
import org.celllife.idart.domain.encounter.EncounterValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Component class HibernateEncounterValidator implements EncounterValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Encounter encounter) throws EncounterValidationException {

        Set<ConstraintViolation<Encounter>> constraintViolations = validatorFactory.validator.validate(encounter)

        if (!constraintViolations.empty) {
            throw new EncounterValidationException(constraintViolations)
        }
    }
}
