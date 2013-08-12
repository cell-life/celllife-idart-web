package org.celllife.idart.infrastructure.jsr303.substitutionreason

import org.celllife.idart.domain.substitutionreason.SubstitutionReason
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonValidationException
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303SubstitutionReasonValidator implements SubstitutionReasonValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(SubstitutionReason substitutionReason) throws SubstitutionReasonValidationException {

        Set<ConstraintViolation<SubstitutionReason>> constraintViolations = validatorFactory.validator.validate(substitutionReason)

        if (!constraintViolations.empty) {
            throw new SubstitutionReasonValidationException(constraintViolations)
        }
    }
}
