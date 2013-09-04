package org.celllife.idart.interfaces.resource.practitioner

import org.celllife.idart.common.PractitionerId
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.practitioner.PractitionerNotFoundException
import org.celllife.idart.domain.practitioner.PractitionerValidationException
import org.celllife.idart.security.practitioner.PractitionerSecurityAdapter
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
@Controller class PractitionerResourceController {

    @Inject PractitionerSecurityAdapter practitionerSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/practitioners/{practitionerId}", method = GET, produces = "application/json")
    Practitioner findByPractitionerId(@PathVariable("practitionerId") PractitionerId practitionerId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            practitionerSecurityAdapter.findByPractitionerId(principal, practitionerId)

        } catch (PractitionerNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/practitioners", method = POST)
    void save(@RequestBody Practitioner practitioner, Principal principal, HttpServletResponse response) {

        try {

            practitioner = practitionerSecurityAdapter.save(principal, practitioner)

            response.setHeader("Location", "${baseUrl}/practitioners/${practitioner.id}")
            response.setStatus(SC_CREATED)

        } catch (PractitionerValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
