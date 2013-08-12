package org.celllife.idart.domain.user

import org.celllife.idart.common.UserIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.user.UserEvent.EventType.SAVED
import static org.celllife.idart.domain.user.UserEvent.newUserEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class UserServiceImpl implements UserService {

    @Autowired UserRepository userRepository

    @Autowired UserValidator userValidator

    @Autowired UserEventPublisher userEventPublisher

    @Override
    User save(User user) throws UserValidationException {

        userValidator.validate(user)

        userEventPublisher.publish(newUserEvent(user, SAVED))

        userRepository.save(user)
    }

    @Override
    User findByUserIdentifier(UserIdentifier userIdentifier) throws UserNotFoundException {

        def user = userRepository.findOne(userIdentifier)

        if (user == null) {
            throw new UserNotFoundException("Could not find User with User Identifier [${ userIdentifier}]")
        }

        user
    }
}