package org.celllife.idart.infrastructure.jsr303.prescribedmedication

import org.celllife.idart.domain.prescribedmedication.PrescribedMedication
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationValidationException
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303PrescribedMedicationValidator implements PrescribedMedicationValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(PrescribedMedication prescribedMedication) throws PrescribedMedicationValidationException {

        Set<ConstraintViolation<PrescribedMedication>> constraintViolations = validatorFactory.validator.validate(prescribedMedication)

        if (!constraintViolations.empty) {
            throw new PrescribedMedicationValidationException(constraintViolations)
        }
    }
}
