package org.celllife.idart.application.user

import org.celllife.idart.application.user.dto.UserDto
import org.celllife.idart.application.user.dto.UserDtoAssembler
import org.celllife.idart.common.UserId
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.user.UserNotFoundException
import org.celllife.idart.domain.user.UserService

import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.UserId.userId
import static org.celllife.idart.common.IdentifiableType.USER
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UserApplicationServiceImpl implements UserApplicationService {

    @Inject UserService userService   

    @Inject UserDtoAssembler userDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(UserId userId) {
        userService.exists(userId)
    }

    @Override
    UserId save(UserDto userDto) {

        def identifiable = identifiableService.resolveIdentifiable(USER, userDto.identifiers)

        def userId = userId(identifiable.getIdentifierValue(IDART))

        def user = userDtoAssembler.toUser(userDto)
        user.id = userId

        userService.save(user)

        user.id
    }

    @Override
    UserDto findByUserId(UserId userId) {
        def identifier = newIdentifier(IDART, userId.value)
        findByIdentifier(identifier)
    }

    @Override
    UserDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(USER, [identifier] as Set)

        if (identifiable == null) {
            throw new UserNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def userId = userId(identifiable.getIdentifierValue(IDART))

        def user = userService.findByUserId(userId)

        def userDto = userDtoAssembler.toUserDto(user)
        userDto.identifiers = identifiable.identifiers

        userDto
    }

    @Override
    UserId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(USER, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART)

        userId(idartIdentifierValue)
    }
}
