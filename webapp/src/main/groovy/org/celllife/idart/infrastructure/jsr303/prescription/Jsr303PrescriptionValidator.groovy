package org.celllife.idart.infrastructure.jsr303.prescription

import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.prescription.PrescriptionValidationException
import org.celllife.idart.domain.prescription.PrescriptionValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303PrescriptionValidator implements PrescriptionValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Prescription prescription) throws PrescriptionValidationException {

        Set<ConstraintViolation<Prescription>> constraintViolations = validatorFactory.validator.validate(prescription)

        if (!constraintViolations.empty) {
            throw new PrescriptionValidationException(constraintViolations)
        }
    }
}
