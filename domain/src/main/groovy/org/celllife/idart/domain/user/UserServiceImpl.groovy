package org.celllife.idart.domain.user

import org.celllife.idart.common.UserId

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.user.UserEvent.EventType.SAVED
import static org.celllife.idart.domain.user.UserEvent.newUserEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UserServiceImpl implements UserService {

    @Inject UserRepository userRepository

    @Inject UserValidator userValidator

    @Inject UserEventPublisher userEventPublisher

    @Override
    User save(User user) {

        userValidator.validate(user)

        userEventPublisher.publish(newUserEvent(user, SAVED))

        userRepository.save(user)
    }

    @Override
    User findByUserId(UserId userId) {

        def user = userRepository.findOne(userId)

        if (user == null) {
            throw new UserNotFoundException("Could not find User with User Id [${ userId}]")
        }

        user
    }
}
