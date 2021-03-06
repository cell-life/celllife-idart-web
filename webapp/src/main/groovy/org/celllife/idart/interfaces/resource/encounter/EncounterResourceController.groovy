package org.celllife.idart.interfaces.resource.encounter

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND

import java.security.Principal

import javax.inject.Inject
import javax.servlet.http.HttpServletResponse

import org.celllife.idart.application.encounter.dto.EncounterDto
import org.celllife.idart.common.EncounterId
import org.celllife.idart.domain.encounter.EncounterNotFoundException
import org.celllife.idart.domain.encounter.EncounterValidationException
import org.celllife.idart.security.encounter.EncounterSecurityAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 */
@Controller class EncounterResourceController {

    static final Logger LOGGER = LoggerFactory.getLogger(EncounterResourceController)

    @Inject EncounterSecurityAdapter encounterSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/encounters/{encounterId}", method = RequestMethod.GET, produces = "application/json")
    EncounterDto findByEncounterId(@PathVariable("encounterId") EncounterId encounterId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return encounterSecurityAdapter.findByEncounterId(principal, encounterId)

        } catch (EncounterNotFoundException ignore) {
            LOGGER.error("Could not find Encounter with id "+encounterId, ignore)
            response.setStatus(SC_NOT_FOUND)
            return null
        }
    }

    @RequestMapping(value = "/encounters", method = RequestMethod.POST)
    void save(@RequestBody EncounterDto encounterDto, Principal principal, HttpServletResponse response) {

        try {

            EncounterId encounterId = encounterSecurityAdapter.save(principal, encounterDto)

            response.setHeader("Location", "${baseUrl}/encounters/${encounterId}")
            response.setStatus(SC_CREATED)

        } catch (EncounterValidationException e) {
            LOGGER.error("Could not save Encounter "+encounterDto, e)
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
