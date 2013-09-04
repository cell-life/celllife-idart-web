package org.celllife.idart.interfaces.resource.facility

import org.celllife.idart.common.FacilityId
import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.facility.FacilityNotFoundException
import org.celllife.idart.domain.facility.FacilityValidationException
import org.celllife.idart.security.facility.FacilitySecurityAdapter
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
@Controller class FacilityResourceController {

    @Inject FacilitySecurityAdapter facilitySecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/facilities/{facilityId}", method = GET, produces = "application/json")
    Facility findByFacilityId(@PathVariable("facilityId") FacilityId facilityId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            facilitySecurityAdapter.findByFacilityId(principal, facilityId)

        } catch (FacilityNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/facilities", method = POST)
    void save(@RequestBody Facility facility, Principal principal, HttpServletResponse response) {

        try {

            facility = facilitySecurityAdapter.save(principal, facility)

            response.setHeader("Location", "${baseUrl}/facilitys/${facility.id}")
            response.setStatus(SC_CREATED)

        } catch (FacilityValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
