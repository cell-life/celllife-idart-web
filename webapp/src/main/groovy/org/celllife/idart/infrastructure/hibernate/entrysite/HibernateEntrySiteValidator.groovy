package org.celllife.idart.infrastructure.hibernate.entrysite

import org.celllife.idart.domain.entrysite.EntrySite
import org.celllife.idart.domain.entrysite.EntrySiteValidationException
import org.celllife.idart.domain.entrysite.EntrySiteValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Component class HibernateEntrySiteValidator implements EntrySiteValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(EntrySite entrySite) throws EntrySiteValidationException {

        Set<ConstraintViolation<EntrySite>> constraintViolations = validatorFactory.validator.validate(entrySite)

        if (!constraintViolations.empty) {
            throw new EntrySiteValidationException(constraintViolations)
        }
    }
}
