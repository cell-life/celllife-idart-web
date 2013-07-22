package org.celllife.idart.interfaces.service.person

import org.celllife.idart.application.person.PersonResourceService
import org.celllife.idart.domain.person.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.annotation.Generated
import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_CREATED

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class PersonResourceController {

    @Autowired PersonResourceService personResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/persons",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<Person> findAll(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        personResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/persons/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Person findByIdentifier(@PathVariable("coidentifierde") String identifier, @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        personResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    void save(@RequestBody Person person, HttpServletResponse response) {

        person = personResourceService.save(person)

        response.setHeader("Location", "${baseUrl}/service/persons/${person.pk}")
        response.setStatus(SC_CREATED)
    }
}
