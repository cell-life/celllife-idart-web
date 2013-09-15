package org.celllife.idart.interfaces.resource.practitioner

import org.celllife.idart.application.practitioner.dto.PractitionerDto
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.practitioner.PractitionerNotFoundException
import org.celllife.idart.domain.practitioner.PractitionerValidationException
import org.celllife.idart.security.practitioner.PractitionerSecurityAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.inject.Inject
import javax.servlet.http.HttpServletResponse
import java.security.Principal

import static javax.servlet.http.HttpServletResponse.*

/**
 */
@Controller class PractitionerResourceController {

    @Inject PractitionerSecurityAdapter practitionerSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/practitioners/findByIdentifier", method = RequestMethod.GET, produces = "application/json")
    Set<PractitionerDto> findAll(@ModelAttribute Identifier identifier,
                                 Principal principal,
                                 HttpServletResponse response) {

        try {

            return practitionerSecurityAdapter.findByIdentifier(principal, identifier)

        } catch (PractitionerNotFoundException ignore) {

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
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
