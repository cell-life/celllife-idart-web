package org.celllife.idart.application.user

import org.celllife.idart.domain.user.User
import org.celllife.idart.domain.user.UserValidationException
import org.celllife.idart.domain.user.UserNotFoundException
import org.celllife.idart.domain.user.UserIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface UserApplicationService {

    User save(User user) throws UserValidationException

    User findByIdentifier(UserIdentifier identifier) throws UserNotFoundException

}