package org.celllife.idart.security.user

import org.celllife.idart.application.user.dto.UserDto
import org.celllife.idart.common.UserId
import org.celllife.idart.common.Identifier
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

    UserId save(Principal principal, UserDto userDto) {
        userApplicationService.save(userDto)
    }

    UserDto findByUserId(Principal principal, UserId userId) {
        userApplicationService.findByUserId(userId)
    }

    UserDto findByIdentifier(Principal principal, Identifier identifier) {
        userApplicationService.findByIdentifier(identifier)
    }

}
