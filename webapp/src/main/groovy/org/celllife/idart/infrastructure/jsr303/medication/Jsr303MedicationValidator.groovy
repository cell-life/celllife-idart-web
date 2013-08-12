package org.celllife.idart.infrastructure.jsr303.medication

import org.celllife.idart.domain.medication.Medication
import org.celllife.idart.domain.medication.MedicationValidationException
import org.celllife.idart.domain.medication.MedicationValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303MedicationValidator implements MedicationValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Medication medication) throws MedicationValidationException {

        Set<ConstraintViolation<Medication>> constraintViolations = validatorFactory.validator.validate(medication)

        if (!constraintViolations.empty) {
            throw new MedicationValidationException(constraintViolations)
        }
    }
}
