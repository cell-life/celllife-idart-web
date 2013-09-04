package org.celllife.idart.security.user

import org.celllife.idart.common.UserId
import org.celllife.idart.domain.user.User
import org.celllife.idart.application.user.UserApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UserSecurityAdapter {

    @Inject UserApplicationService userApplicationService

    User save(Principal principal, User user) {
        userApplicationService.save(user)
    }

    User findByUserId(Principal principal, UserId userId) {
        userApplicationService.findByUserId(userId)
    }

}
