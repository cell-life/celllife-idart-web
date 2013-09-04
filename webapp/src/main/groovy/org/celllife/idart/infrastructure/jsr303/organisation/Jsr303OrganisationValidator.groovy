package org.celllife.idart.infrastructure.jsr303.organisation

import org.celllife.idart.domain.organisation.Organisation
import org.celllife.idart.domain.organisation.OrganisationValidationException
import org.celllife.idart.domain.organisation.OrganisationValidator
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
@Named class Jsr303OrganisationValidator implements OrganisationValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(Organisation organisation) {

        Set<ConstraintViolation<Organisation>> constraintViolations = validatorFactory.validator.validate(organisation)

        if (!constraintViolations.empty) {
            throw new OrganisationValidationException(constraintViolations)
        }
    }
}
