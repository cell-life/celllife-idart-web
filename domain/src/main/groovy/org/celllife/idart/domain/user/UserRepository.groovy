package org.celllife.idart.domain.user

import org.celllife.idart.common.UserId

import javax.annotation.Generated

/**
 */
public interface UserRepository {

    boolean exists(UserId userId)

    User save(User user)

    User findOne(UserId userId)

    UserId findByUsername(String username)
}
