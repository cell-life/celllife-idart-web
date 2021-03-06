package org.celllife.idart.application.user

import static org.celllife.idart.common.IdentifiableType.USER
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Systems.IDART_WEB
import static org.celllife.idart.common.UserId.userId

import javax.inject.Inject
import javax.inject.Named

import org.celllife.idart.application.user.dto.UserDto
import org.celllife.idart.application.user.dto.UserDtoAssembler
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.UserId
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.user.DuplicateUsernameException
import org.celllife.idart.domain.user.UserNotFoundException
import org.celllife.idart.domain.user.UserService
import org.springframework.transaction.annotation.Transactional

/**
 */
@Named class UserApplicationServiceImpl implements UserApplicationService {

    @Inject UserService userService   

    @Inject UserDtoAssembler userDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    @Transactional(readOnly = true)
    Boolean exists(UserId userId) {
        userService.exists(userId)
    }

    @Override
    @Transactional
    UserId save(UserDto userDto) {

        // see if there is already a user with the same username
        UserId existingUserId = userService.findByUsername(userDto.getUsername())
        if (userDto.identifiers.empty && existingUserId != null) {
            throw new DuplicateUsernameException("There is already a user with the username '"+userDto.getUsername()+"'")
        }

        def identifiable = identifiableService.resolveIdentifiable(USER, userDto.identifiers)
        userDto.identifiers = identifiable.identifiers

        def userId = userId(identifiable.getIdentifierValue(IDART_WEB.id))

        // check again to see if there was an existing user with the same username, then the IDs should match
        if (existingUserId != null && !existingUserId.equals(userId)) {
            // FIXME: at this point a new ID would be created, so there is some waste (sorry)
            throw new DuplicateUsernameException("There is already a user with the username '"+userDto.getUsername()+"'")
        }

        def user = userDtoAssembler.toUser(userDto)
        user.id = userId

        userService.save(user)

        user.id
    }

    @Override
    @Transactional(readOnly = true)
    UserDto findByUserId(UserId userId) {
        def identifier = newIdentifier(userId.value)
        findByIdentifier(identifier)
    }

    @Override
    @Transactional(readOnly = true)
    UserDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(USER, [identifier] as Set)
        if (identifiable == null) {
            throw new UserNotFoundException("Could not find User with id [${identifier}]")
        }

        def userId = userId(identifiable.getIdentifierValue(IDART_WEB.id))

        def user = userService.findByUserId(userId)

        def userDto = userDtoAssembler.toUserDto(user)
        userDto.identifiers = identifiable.identifiers

        userDto
    }

    @Override
    @Transactional(readOnly = true)
    UserId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.findByIdentifiers(USER, identifiers)
        if (identifiable == null) {
            throw new UserNotFoundException("Could not find User with id [${identifiers}]")
        }

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        userId(idartIdentifierValue)
    }
}