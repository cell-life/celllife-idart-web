package org.celllife.idart.infrastructure.jsr303.person

import org.celllife.idart.domain.person.Person
import org.celllife.idart.domain.person.PersonValidationException
import org.celllife.idart.domain.person.PersonValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.inject.Inject
import javax.inject.Named
import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

/**
 */
@Named class Jsr303PersonValidator implements PersonValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(Person person) {

        Set<ConstraintViolation<Person>> constraintViolations = validatorFactory.validator.validate(person)

        if (!constraintViolations.empty) {
            throw new PersonValidationException(constraintViolations)
        }
    }
}
