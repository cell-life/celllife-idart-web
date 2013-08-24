package org.celllife.idart.application.user

import org.celllife.idart.domain.user.User
import org.celllife.idart.domain.user.UserValidationException
import org.celllife.idart.domain.user.UserNotFoundException
import org.celllife.idart.common.UserId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface UserApplicationService {

    User save(User user) throws UserValidationException

    User findByUserId(UserId userId) throws UserNotFoundException

}
