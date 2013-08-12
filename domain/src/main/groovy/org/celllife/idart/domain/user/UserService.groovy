package org.celllife.idart.domain.user

import org.celllife.idart.common.UserIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UserService {

    User save(User user) throws UserValidationException

    User findByUserIdentifier(UserIdentifier userIdentifier) throws UserNotFoundException

}