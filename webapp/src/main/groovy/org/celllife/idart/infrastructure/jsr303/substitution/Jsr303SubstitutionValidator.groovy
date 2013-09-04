package org.celllife.idart.infrastructure.jsr303.substitution

import org.celllife.idart.domain.substitution.Substitution
import org.celllife.idart.domain.substitution.SubstitutionValidationException
import org.celllife.idart.domain.substitution.SubstitutionValidator
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
@Named class Jsr303SubstitutionValidator implements SubstitutionValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(Substitution substitution) {

        Set<ConstraintViolation<Substitution>> constraintViolations = validatorFactory.validator.validate(substitution)

        if (!constraintViolations.empty) {
            throw new SubstitutionValidationException(constraintViolations)
        }
    }
}
