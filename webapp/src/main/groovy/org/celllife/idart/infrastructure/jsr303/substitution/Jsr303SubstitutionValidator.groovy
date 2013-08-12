package org.celllife.idart.infrastructure.jsr303.substitution

import org.celllife.idart.domain.substitution.Substitution
import org.celllife.idart.domain.substitution.SubstitutionValidationException
import org.celllife.idart.domain.substitution.SubstitutionValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303SubstitutionValidator implements SubstitutionValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Substitution substitution) throws SubstitutionValidationException {

        Set<ConstraintViolation<Substitution>> constraintViolations = validatorFactory.validator.validate(substitution)

        if (!constraintViolations.empty) {
            throw new SubstitutionValidationException(constraintViolations)
        }
    }
}
