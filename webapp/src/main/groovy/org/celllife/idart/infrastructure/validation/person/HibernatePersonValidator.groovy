package org.celllife.idart.infrastructure.validation.person

import org.celllife.idart.domain.person.Person
import org.celllife.idart.domain.person.PersonValidationException
import org.celllife.idart.domain.person.PersonValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Component class HibernatePersonValidator implements PersonValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Person person) throws PersonValidationException {

        Set<ConstraintViolation<Person>> constraintViolations = validatorFactory.validator.validate(person)

        if (!constraintViolations.empty) {
            throw new PersonValidationException(constraintViolations)
        }
    }
}
