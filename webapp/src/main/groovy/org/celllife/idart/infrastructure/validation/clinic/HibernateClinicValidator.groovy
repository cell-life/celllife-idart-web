package org.celllife.idart.infrastructure.validation.clinic

import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.clinic.ClinicValidationException
import org.celllife.idart.domain.clinic.ClinicValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Component class HibernateClinicValidator implements ClinicValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Clinic clinic) throws ClinicValidationException {

        Set<ConstraintViolation<Clinic>> constraintViolations = validatorFactory.validator.validate(clinic)

        if (!constraintViolations.empty) {
            throw new ClinicValidationException(constraintViolations)
        }
    }
}
