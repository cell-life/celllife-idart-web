package org.celllife.idart.infrastructure.validation.organisation

import org.celllife.idart.domain.organisation.LegalOrganisation
import org.celllife.idart.domain.organisation.LegalOrganisationValidationException
import org.celllife.idart.domain.organisation.LegalOrganisationValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Component class HibernateLegalOrganisationValidator implements LegalOrganisationValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(LegalOrganisation legalOrganisation) throws LegalOrganisationValidationException {

        Set<ConstraintViolation<LegalOrganisation>> constraintViolations = validatorFactory.validator.validate(legalOrganisation)

        if (!constraintViolations.empty) {
            throw new LegalOrganisationValidationException(constraintViolations)
        }
    }
}
