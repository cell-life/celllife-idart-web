package org.celllife.idart.infrastructure.jsr303.dispensedmedication

import org.celllife.idart.domain.dispensedmedication.DispensedMedication
import org.celllife.idart.domain.dispensedmedication.DispensedMedicationValidationException
import org.celllife.idart.domain.dispensedmedication.DispensedMedicationValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303DispensedMedicationValidator implements DispensedMedicationValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(DispensedMedication dispensedMedication) throws DispensedMedicationValidationException {

        Set<ConstraintViolation<DispensedMedication>> constraintViolations = validatorFactory.validator.validate(dispensedMedication)

        if (!constraintViolations.empty) {
            throw new DispensedMedicationValidationException(constraintViolations)
        }
    }
}
