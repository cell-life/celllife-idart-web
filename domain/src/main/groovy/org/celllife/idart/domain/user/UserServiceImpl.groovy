package org.celllife.idart.domain.user

import static org.celllife.idart.domain.user.UserEvent.newUserEvent
import static org.celllife.idart.domain.user.UserEvent.EventType.SAVED

import javax.inject.Inject
import javax.inject.Named

import org.celllife.idart.common.UserId

/**
 */
@Named class UserServiceImpl implements UserService {

    @Inject UserRepository userRepository

    @Inject UserValidator userValidator

    @Inject UserEventPublisher userEventPublisher

    @Override
    Boolean exists(UserId userId) {
        userRepository.exists(userId)
    }

    @Override
    User save(User user) {

        def existingUser = userRepository.findOne(user.id)

        if (existingUser == null) {
            existingUser = user
        } else {
            existingUser.merge(user)
        }

        userValidator.validate(existingUser)

        userEventPublisher.publish(newUserEvent(existingUser, SAVED))

        userRepository.save(existingUser)
    }

    @Override
    User findByUserId(UserId userId) {

        def user = userRepository.findOne(userId)

        if (user == null) {
            throw new UserNotFoundException("Could not find User with id [${ userId}]")
        }

        user
    }

    @Override
    UserId findByUsername(String username) {
        userRepository.findByUsername(username)
    }
}
