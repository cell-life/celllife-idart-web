package org.celllife.idart.application.user.dto

import org.celllife.idart.domain.user.User
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UserDtoAssembler {

    static User toUser(UserDto userDto) {

        def user = new User()
        user.with {

        }

        user
    }

    static UserDto toUserDto(User user) {

        def userDto = new UserDto()
        userDto.with {

        }

        userDto
    }
}
