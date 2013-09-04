package org.celllife.idart.infrastructure.jsr303.substitutionreason

import org.celllife.idart.domain.substitutionreason.SubstitutionReason
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonValidationException
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonValidator
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
@Named class Jsr303SubstitutionReasonValidator implements SubstitutionReasonValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(SubstitutionReason substitutionReason) {

        Set<ConstraintViolation<SubstitutionReason>> constraintViolations = validatorFactory.validator.validate(substitutionReason)

        if (!constraintViolations.empty) {
            throw new SubstitutionReasonValidationException(constraintViolations)
        }
    }
}
