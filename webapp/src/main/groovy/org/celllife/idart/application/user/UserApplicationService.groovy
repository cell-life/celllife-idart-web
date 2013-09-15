package org.celllife.idart.application.user

import org.celllife.idart.application.user.dto.UserDto
import org.celllife.idart.common.UserId
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface UserApplicationService {

    Boolean exists(UserId userId)

    UserId save(UserDto userDto)

    UserDto findByUserId(UserId userId)

    UserDto findByIdentifier(Identifier identifier)

}
