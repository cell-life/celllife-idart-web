package org.celllife.idart.infrastructure.jsr303.legalorganisation

import org.celllife.idart.domain.legalorganisation.LegalOrganisation
import org.celllife.idart.domain.legalorganisation.LegalOrganisationValidationException
import org.celllife.idart.domain.legalorganisation.LegalOrganisationValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303LegalOrganisationValidator implements LegalOrganisationValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(LegalOrganisation legalOrganisation) throws LegalOrganisationValidationException {

        Set<ConstraintViolation<LegalOrganisation>> constraintViolations = validatorFactory.validator.validate(legalOrganisation)

        if (!constraintViolations.empty) {
            throw new LegalOrganisationValidationException(constraintViolations)
        }
    }
}
