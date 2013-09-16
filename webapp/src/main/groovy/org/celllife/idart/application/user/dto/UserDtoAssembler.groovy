package org.celllife.idart.application.user.dto

import org.celllife.idart.domain.user.User

import javax.inject.Named

/**
 */
@Named class UserDtoAssembler {

    User toUser(UserDto userDto) {

        def user = new User()
        user.with {
            username = userDto.username
            password = userDto.password
        }

        user
    }

    UserDto toUserDto(User user) {

        def userDto = new UserDto()
        userDto.with {
            username = user.username
        }

        userDto
    }
}
