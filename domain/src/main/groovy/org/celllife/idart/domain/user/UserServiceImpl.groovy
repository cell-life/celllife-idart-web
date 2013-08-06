package org.celllife.idart.domain.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
//@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class UserServiceImpl implements UserService {

    @Autowired UserRepository userRepository

    @Autowired UserValidator userValidator

    @Autowired UserEventPublisher userEventPublisher

    @Override
    User save(User user) throws UserValidationException {

        userValidator.validate(user)

        userEventPublisher.userSaved(user)

        userRepository.save(user)
    }

    @Override
    User findByIdentifier(UserIdentifier identifier) throws UserNotFoundException {

        def user = userRepository.findOne(identifier)

        if (user == null) {
            throw new UserNotFoundException("Could not find User with Identifier [${ identifier}]")
        }

        user
    }
}