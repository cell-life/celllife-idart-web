package org.celllife.idart.domain.user

import org.celllife.idart.common.UserIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UserRepository {

    User save(User user)

    User findOne(UserIdentifier userIdentifier)

}
