package org.celllife.idart.infrastructure.jsr303.entrysite

import org.celllife.idart.domain.entrysite.EntrySite
import org.celllife.idart.domain.entrysite.EntrySiteValidationException
import org.celllife.idart.domain.entrysite.EntrySiteValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303EntrySiteValidator implements EntrySiteValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(EntrySite entrySite) throws EntrySiteValidationException {

        Set<ConstraintViolation<EntrySite>> constraintViolations = validatorFactory.validator.validate(entrySite)

        if (!constraintViolations.empty) {
            throw new EntrySiteValidationException(constraintViolations)
        }
    }
}
