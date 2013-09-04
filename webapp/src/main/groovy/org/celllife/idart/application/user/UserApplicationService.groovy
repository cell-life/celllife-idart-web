package org.celllife.idart.application.user

import org.celllife.idart.common.UserId
import org.celllife.idart.domain.user.User

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface UserApplicationService {

    User save(User user)

    User findByUserId(UserId userId)

}
