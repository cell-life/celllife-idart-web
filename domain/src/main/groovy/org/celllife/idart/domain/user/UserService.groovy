package org.celllife.idart.domain.user

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UserService {

    User save(User user) throws UserValidationException

    User findByIdentifier(UserIdentifier identifier) throws UserNotFoundException

}