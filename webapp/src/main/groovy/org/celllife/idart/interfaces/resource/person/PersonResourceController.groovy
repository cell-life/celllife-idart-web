package org.celllife.idart.interfaces.resource.person

import org.celllife.idart.common.PersonId
import org.celllife.idart.domain.person.Person
import org.celllife.idart.domain.person.PersonNotFoundException
import org.celllife.idart.domain.person.PersonValidationException
import org.celllife.idart.security.person.PersonSecurityAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import javax.annotation.Generated
import javax.inject.Inject
import javax.servlet.http.HttpServletResponse
import java.security.Principal

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND
import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class PersonResourceController {

    @Inject PersonSecurityAdapter personSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/persons/{personId}", method = GET, produces = "application/json")
    Person findByPersonId(@PathVariable("personId") PersonId personId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            personSecurityAdapter.findByPersonId(principal, personId)

        } catch (PersonNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/persons", method = POST)
    void save(@RequestBody Person person, Principal principal, HttpServletResponse response) {

        try {

            person = personSecurityAdapter.save(principal, person)

            response.setHeader("Location", "${baseUrl}/persons/${person.id}")
            response.setStatus(SC_CREATED)

        } catch (PersonValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
