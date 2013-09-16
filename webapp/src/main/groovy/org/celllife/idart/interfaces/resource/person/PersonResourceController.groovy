package org.celllife.idart.interfaces.resource.person

import org.celllife.idart.common.PersonId
import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.domain.person.PersonNotFoundException
import org.celllife.idart.domain.person.PersonValidationException
import org.celllife.idart.security.person.PersonSecurityAdapter
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
@Controller class PersonResourceController {

    @Inject PersonSecurityAdapter personSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/people/{personId}", method = RequestMethod.GET, produces = "application/json")
    PersonDto findByPersonId(@PathVariable("personId") PersonId personId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return personSecurityAdapter.findByPersonId(principal, personId)

        } catch (PersonNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    void save(@RequestBody PersonDto personDto, Principal principal, HttpServletResponse response) {

        try {

            PersonId personId = personSecurityAdapter.save(principal, personDto)

            response.setHeader("Location", "${baseUrl}/people/${personId}")
            response.setStatus(SC_CREATED)

        } catch (PersonValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
