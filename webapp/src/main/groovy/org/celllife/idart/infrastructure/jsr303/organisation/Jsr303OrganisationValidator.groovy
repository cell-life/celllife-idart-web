package org.celllife.idart.infrastructure.jsr303.organisation

import org.celllife.idart.domain.organisation.Organisation
import org.celllife.idart.domain.organisation.OrganisationValidationException
import org.celllife.idart.domain.organisation.OrganisationValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303OrganisationValidator implements OrganisationValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Organisation organisation) throws OrganisationValidationException {

        Set<ConstraintViolation<Organisation>> constraintViolations = validatorFactory.validator.validate(organisation)

        if (!constraintViolations.empty) {
            throw new OrganisationValidationException(constraintViolations)
        }
    }
}
