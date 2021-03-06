package org.celllife.idart.application.user

import org.celllife.idart.application.user.dto.UserDto
import org.celllife.idart.common.UserId
import org.celllife.idart.common.Identifier


/**
 */
interface UserApplicationService {

    Boolean exists(UserId userId)

    UserId save(UserDto userDto)

    UserDto findByUserId(UserId userId)

    UserDto findByIdentifier(Identifier identifier)

    UserId findByIdentifiers(Set<Identifier> identifiers)

}
