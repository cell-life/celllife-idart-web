package org.celllife.idart.infrastructure.jsr303.person

import org.celllife.idart.domain.person.Person
import org.celllife.idart.domain.person.PersonValidationException
import org.celllife.idart.domain.person.PersonValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303PersonValidator implements PersonValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(Person person) throws PersonValidationException {

        Set<ConstraintViolation<Person>> constraintViolations = validatorFactory.validator.validate(person)

        if (!constraintViolations.empty) {
            throw new PersonValidationException(constraintViolations)
        }
    }
}
