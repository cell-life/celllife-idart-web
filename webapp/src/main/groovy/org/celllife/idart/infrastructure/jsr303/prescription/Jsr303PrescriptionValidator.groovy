package org.celllife.idart.infrastructure.jsr303.prescription

import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.prescription.PrescriptionValidationException
import org.celllife.idart.domain.prescription.PrescriptionValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.inject.Inject
import javax.inject.Named
import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Named class Jsr303PrescriptionValidator implements PrescriptionValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(Prescription prescription) {

        Set<ConstraintViolation<Prescription>> constraintViolations = validatorFactory.validator.validate(prescription)

        if (!constraintViolations.empty) {
            throw new PrescriptionValidationException(constraintViolations)
        }
    }
}
