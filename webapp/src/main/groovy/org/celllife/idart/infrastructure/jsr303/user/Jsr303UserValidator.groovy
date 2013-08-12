package org.celllife.idart.infrastructure.jsr303.user

import org.celllife.idart.domain.user.User
import org.celllife.idart.domain.user.UserValidationException
import org.celllife.idart.domain.user.UserValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.validation.ConstraintViolation
import javax.validation.ValidatorFactory

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class Jsr303UserValidator implements UserValidator {

    @Autowired ValidatorFactory validatorFactory

    @Override
    void validate(User user) throws UserValidationException {

        Set<ConstraintViolation<User>> constraintViolations = validatorFactory.validator.validate(user)

        if (!constraintViolations.empty) {
            throw new UserValidationException(constraintViolations)
        }
    }
}
