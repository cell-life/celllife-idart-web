package org.celllife.idart.infrastructure.jsr303.facility

import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.facility.FacilityValidationException
import org.celllife.idart.domain.facility.FacilityValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.inject.Inject
import javax.inject.Named
import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Named class Jsr303FacilityValidator implements FacilityValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(Facility facility) {

        Set<ConstraintViolation<Facility>> constraintViolations = validatorFactory.validator.validate(facility)

        if (!constraintViolations.empty) {
            throw new FacilityValidationException(constraintViolations)
        }
    }
}
