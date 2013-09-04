package org.celllife.idart.application.user

import org.celllife.idart.common.UserId
import org.celllife.idart.domain.user.User
import org.celllife.idart.domain.user.UserService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UserApplicationServiceImpl implements UserApplicationService {

    @Inject UserService userService

    User save(User user) {
        userService.save(user)
    }

    User findByUserId(UserId userId) {
        userService.findByUserId(userId)
    }

}
