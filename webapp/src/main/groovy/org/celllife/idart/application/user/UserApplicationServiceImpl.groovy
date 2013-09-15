package org.celllife.idart.application.user

import org.celllife.idart.application.user.dto.UserDto
import org.celllife.idart.common.UserId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.user.UserNotFoundException
import org.celllife.idart.domain.user.UserService

import static org.celllife.idart.application.user.dto.UserDtoAssembler.toUser
import static org.celllife.idart.application.user.dto.UserDtoAssembler.toUserDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.UserId.userId
import static org.celllife.idart.domain.identifiable.IdentifiableType.USER
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UserApplicationServiceImpl implements UserApplicationService {

    @Inject UserService userService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(UserId userId) {
        userService.exists(userId)
    }

    UserId save(UserDto userDto) {

        def user = toUser(userDto)

        def identifiable = identifiableService.findByIdentifiers(USER, userDto.identifiers)
        if (identifiable == null) {

            user = userService.save(user)

            identifiable = new Identifiable(type: USER, identifiers: userDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, user.id.value))
            identifiableService.save(identifiable)

        } else {

            user.id = userId(identifiable.getIdentifier(IDART).value)
            userService.save(user)

        }

        user.id
    }

    @Override
    UserDto findByUserId(UserId userId) {
        def identifier = newIdentifier(IDART, userId.value)
        findByIdentifier(identifier)
    }

    @Override
    UserDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(USER, [identifier] as Set)

        if (identifiable == null) {
            throw new UserNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def userId = userId(identifiable.getIdentifier(IDART).value)

        def user = userService.findByUserId(userId)

        def userDto = toUserDto(user)
        userDto.identifiers = identifiable.identifiers

        userDto
    }
}
