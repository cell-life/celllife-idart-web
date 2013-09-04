package org.celllife.idart.infrastructure.jsr303.prescribedmedication

import org.celllife.idart.domain.prescribedmedication.PrescribedMedication
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationValidationException
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class Jsr303PrescribedMedicationValidator implements PrescribedMedicationValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(PrescribedMedication prescribedMedication) {

        Set<ConstraintViolation<PrescribedMedication>> constraintViolations = validatorFactory.validator.validate(prescribedMedication)

        if (!constraintViolations.empty) {
            throw new PrescribedMedicationValidationException(constraintViolations)
        }
    }
}
