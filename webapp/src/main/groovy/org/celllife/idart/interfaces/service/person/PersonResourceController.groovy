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
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class PersonResourceController {

    @Autowired PersonResourceService personResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/people",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<Person> findAll() {
        personResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/people/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Person findByIdentifier(@PathVariable("identifier") String identifier) {
        personResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    void save(@RequestBody Person person, HttpServletResponse response) {

        person = personResourceService.save(person)

        response.setHeader("Location", "${baseUrl}/persons/${person.pk}")
        response.setStatus(SC_CREATED)
    }
}
