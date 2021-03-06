package org.celllife.idart.interfaces.resource.practitioner

import static javax.servlet.http.HttpServletResponse.*

import java.security.Principal

import javax.inject.Inject
import javax.servlet.http.HttpServletResponse

import org.celllife.idart.application.practitioner.dto.PractitionerDto
import org.celllife.idart.common.PractitionerId
import org.celllife.idart.domain.practitioner.PractitionerNotFoundException
import org.celllife.idart.domain.practitioner.PractitionerValidationException
import org.celllife.idart.security.practitioner.PractitionerSecurityAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 */
@Controller class PractitionerResourceController {

    static final Logger LOGGER = LoggerFactory.getLogger(PractitionerResourceController)

    @Inject PractitionerSecurityAdapter practitionerSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/practitioners/{practitionerId}", method = RequestMethod.GET, produces = "application/json")
    PractitionerDto findOne(PractitionerId practitionerId, Principal principal, HttpServletResponse response) {

        try {

            return practitionerSecurityAdapter.findByPractitionerId(principal, practitionerId)

        } catch (PractitionerNotFoundException ignore) {
            LOGGER.error("Could not find practitioner with id "+practitionerId, ignore)
            response.setStatus(SC_NOT_FOUND)
            return null
        }
    }

    @RequestMapping(value = "/practitioners", method = RequestMethod.POST)
    void save(@RequestBody PractitionerDto practitionerDto, Principal principal, HttpServletResponse response) {

        try {

            def practitionerId = practitionerSecurityAdapter.save(principal, practitionerDto)

            response.setHeader("Location", "${baseUrl}/practitioners/${practitionerId}")
            response.setStatus(SC_CREATED)

        } catch (PractitionerValidationException e) {
            LOGGER.error("Could not save practitioner "+practitionerDto, e)
            response.setStatus(SC_BAD_REQUEST)
        }
    }

    @ResponseBody
    @RequestMapping(value = "/practitioners", method = RequestMethod.GET, produces = "application/json")
    Set<PractitionerDto> findAll(Principal principal) {

        practitionerSecurityAdapter.findAll(principal)

    }
}
