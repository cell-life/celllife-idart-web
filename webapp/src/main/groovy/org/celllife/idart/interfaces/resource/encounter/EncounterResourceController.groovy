package org.celllife.idart.interfaces.resource.encounter

import org.celllife.idart.application.encounter.EncounterApplicationService
import org.celllife.idart.domain.encounter.Encounter
import org.celllife.idart.common.EncounterIdentifier
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
@Controller class EncounterResourceController {

    @Autowired EncounterApplicationService encounterApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/encounters/{encounterIdentifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Encounter findByEncounterIdentifier(@PathVariable("encounterIdentifier") EncounterIdentifier encounterIdentifier) {
        encounterApplicationService.findByEncounterIdentifier(encounterIdentifier)
    }

    @RequestMapping(value = "/encounters", method = RequestMethod.POST)
    void save(@RequestBody Encounter encounter, HttpServletResponse response) {

        encounter = encounterApplicationService.save(encounter)

        response.setHeader("Location", "${baseUrl}/encounters/${encounter.identifier}")
        response.setStatus(SC_CREATED)
    }
}
