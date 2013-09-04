package org.celllife.idart.infrastructure.jsr303.user

import org.celllife.idart.domain.user.User
import org.celllife.idart.domain.user.UserValidationException
import org.celllife.idart.domain.user.UserValidator
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
@Named class Jsr303UserValidator implements UserValidator {

    @Inject ValidatorFactory validatorFactory

    @Override
    void validate(User user) {

        Set<ConstraintViolation<User>> constraintViolations = validatorFactory.validator.validate(user)

        if (!constraintViolations.empty) {
            throw new UserValidationException(constraintViolations)
        }
    }
}
