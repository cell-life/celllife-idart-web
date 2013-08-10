package org.celllife.idart.domain.user

import org.celllife.idart.domain.common.EventHeader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Service class UserServiceImpl implements UserService {

    @Autowired UserRepository userRepository

    @Autowired UserValidator userValidator

    @Autowired UserEventPublisher userEventPublisher

    @Override
    User save(User user) throws UserValidationException {

        userValidator.validate(user)

        userEventPublisher.publishUserEvent(new UserEventFactory().username(currentUsername).user(user).build())

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

    static String getCurrentUsername() {
        return null;
    }
}