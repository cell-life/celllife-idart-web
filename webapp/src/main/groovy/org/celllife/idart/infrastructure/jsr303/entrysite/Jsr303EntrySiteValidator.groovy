package org.celllife.idart.infrastructure.jsr303.entrysite

import org.celllife.idart.domain.entrysite.EntrySite
import org.celllife.idart.domain.entrysite.EntrySiteValidationException
import org.celllife.idart.domain.entrysite.EntrySiteValidator
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
@Named class Jsr303EntrySiteValidator implements EntrySiteValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(EntrySite entrySite) {

        Set<ConstraintViolation<EntrySite>> constraintViolations = validatorFactory.validator.validate(entrySite)

        if (!constraintViolations.empty) {
            throw new EntrySiteValidationException(constraintViolations)
        }
    }
}
