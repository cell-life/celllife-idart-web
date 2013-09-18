package org.celllife.idart.infrastructure.jsr303.patient

import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.patient.PatientValidationException
import org.celllife.idart.domain.patient.PatientValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.inject.Inject
import javax.inject.Named
import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Named class Jsr303PatientValidator implements PatientValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(Patient patient) {

        Set<ConstraintViolation<Patient>> constraintViolations = validatorFactory.validator.validate(patient)

        if (!constraintViolations.empty) {
            throw new PatientValidationException(constraintViolations)
        }
    }
}
