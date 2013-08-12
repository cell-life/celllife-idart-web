package org.celllife.idart.application.user

import org.celllife.idart.domain.user.User
import org.celllife.idart.domain.user.UserValidationException
import org.celllife.idart.domain.user.UserNotFoundException
import org.celllife.idart.common.UserIdentifier
import org.celllife.idart.domain.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class UserApplicationServiceImpl implements UserApplicationService {

    @Autowired UserService userService

    User save(User user) throws UserValidationException {
        userService.save(user)
    }

    User findByUserIdentifier(UserIdentifier userIdentifier) throws UserNotFoundException{
        userService.findByUserIdentifier(userIdentifier)
    }

}