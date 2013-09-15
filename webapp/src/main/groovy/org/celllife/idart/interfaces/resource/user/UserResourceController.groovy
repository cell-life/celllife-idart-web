package org.celllife.idart.interfaces.resource.user

import org.celllife.idart.common.UserId
import org.celllife.idart.application.user.dto.UserDto
import org.celllife.idart.domain.user.UserNotFoundException
import org.celllife.idart.domain.user.UserValidationException
import org.celllife.idart.security.user.UserSecurityAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import javax.annotation.Generated
import javax.inject.Inject
import javax.servlet.http.HttpServletResponse
import java.security.Principal

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class UserResourceController {

    @Inject UserSecurityAdapter userSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET, produces = "application/json")
    UserDto findByUserId(@PathVariable("userId") UserId userId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return userSecurityAdapter.findByUserId(principal, userId)

        } catch (UserNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    void save(@RequestBody UserDto userDto, Principal principal, HttpServletResponse response) {

        try {

            UserId userId = userSecurityAdapter.save(principal, userDto)

            response.setHeader("Location", "${baseUrl}/userss/${userId}")
            response.setStatus(SC_CREATED)

        } catch (UserValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
