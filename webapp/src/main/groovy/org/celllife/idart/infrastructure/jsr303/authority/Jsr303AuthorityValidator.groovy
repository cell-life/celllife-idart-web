package org.celllife.idart.infrastructure.jsr303.authority

import org.celllife.idart.domain.authority.Authority
import org.celllife.idart.domain.authority.AuthorityValidationException
import org.celllife.idart.domain.authority.AuthorityValidator
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
@Named class Jsr303AuthorityValidator implements AuthorityValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(Authority authority) {

        Set<ConstraintViolation<Authority>> constraintViolations = validatorFactory.validator.validate(authority)

        if (!constraintViolations.empty) {
            throw new AuthorityValidationException(constraintViolations)
        }
    }
}
