package org.celllife.idart.infrastructure.jsr303.facility

import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.facility.FacilityValidationException
import org.celllife.idart.domain.facility.FacilityValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303FacilityValidator implements FacilityValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Facility facility) throws FacilityValidationException {

        Set<ConstraintViolation<Facility>> constraintViolations = validatorFactory.validator.validate(facility)

        if (!constraintViolations.empty) {
            throw new FacilityValidationException(constraintViolations)
        }
    }
}
