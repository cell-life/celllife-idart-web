package org.celllife.idart.interfaces.resource.person

import org.celllife.idart.application.person.PersonApplicationService
import org.celllife.idart.domain.person.Person
import org.celllife.idart.common.PartyIdentifier
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

    @Autowired PersonApplicationService personApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/persons/{partyIdentifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Person findByPartyIdentifier(@PathVariable("partyIdentifier") PartyIdentifier partyIdentifier) {
        personApplicationService.findByPartyIdentifier(partyIdentifier)
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    void save(@RequestBody Person person, HttpServletResponse response) {

        person = personApplicationService.save(person)

        response.setHeader("Location", "${baseUrl}/persons/${person.identifier}")
        response.setStatus(SC_CREATED)
    }
}
