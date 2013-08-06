package org.celllife.idart.interfaces.resource.user

import org.celllife.idart.application.user.UserApplicationService
import org.celllife.idart.domain.user.User
import org.celllife.idart.domain.user.UserIdentifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.annotation.Generated
import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_CREATED

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class UserResourceController {

    @Autowired UserApplicationService userApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/users/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    User findByIdentifier(@PathVariable("identifier") UserIdentifier identifier) {
        userApplicationService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    void save(@RequestBody User user, HttpServletResponse response) {

        user = userApplicationService.save(user)

        response.setHeader("Location", "${baseUrl}/users/${user.identifier}")
        response.setStatus(SC_CREATED)
    }
}
