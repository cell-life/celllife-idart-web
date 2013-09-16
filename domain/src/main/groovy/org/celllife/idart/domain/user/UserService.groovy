package org.celllife.idart.domain.user

import org.celllife.idart.common.UserId

/**
 */
public interface UserService {

    Boolean exists(UserId userId)

    User save(User user)

    User findByUserId(UserId userId)

    UserId findByUsername(String username)
}
