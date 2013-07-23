package org.celllife.idart.interfaces.service.encounter

import org.celllife.idart.application.encounter.EncounterResourceService
import org.celllife.idart.domain.encounter.Encounter
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
@Controller class EncounterResourceController {

    @Autowired EncounterResourceService encounterResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/encounters",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<Encounter> findAll() {
        encounterResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/encounters/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Encounter findByIdentifier(@PathVariable("coidentifierde") String identifier) {
        encounterResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/encounters", method = RequestMethod.POST)
    void save(@RequestBody Encounter encounter, HttpServletResponse response) {

        encounter = encounterResourceService.save(encounter)

        response.setHeader("Location", "${baseUrl}/encounters/${encounter.pk}")
        response.setStatus(SC_CREATED)
    }
}
