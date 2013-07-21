package org.celllife.idart.infrastructure.validation.prescription

import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.prescription.PrescriptionValidationException
import org.celllife.idart.domain.prescription.PrescriptionValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 19h18
 */
@Component class HibernatePrescriptionValidator implements PrescriptionValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Prescription prescription) throws PrescriptionValidationException {

        Set<ConstraintViolation<Prescription>> constraintViolations = validatorFactory.validator.validate(prescription)

        if (!constraintViolations.empty) {
            throw new PrescriptionValidationException(constraintViolations)
        }
    }
}
