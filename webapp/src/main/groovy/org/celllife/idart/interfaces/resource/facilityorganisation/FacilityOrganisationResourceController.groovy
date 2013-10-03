package org.celllife.idart.interfaces.resource.facilityorganisation

import org.celllife.idart.application.facilityorganisation.dto.FacilityOrganisationDto
import org.celllife.idart.security.facilityorganisation.FacilityOrganisationSecurityAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import javax.inject.Inject
import javax.servlet.http.HttpServletResponse
import java.security.Principal

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED

/**
 */
@Controller class FacilityOrganisationResourceController {

    @Inject FacilityOrganisationSecurityAdapter facilityOrganisationSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @RequestMapping(value = "/facilityOrganisation", method = RequestMethod.POST)
    void save(@RequestBody FacilityOrganisationDto facilityOrganisationDto, Principal principal, HttpServletResponse response) {

        try {

            facilityOrganisationSecurityAdapter.save(principal, facilityOrganisationDto)

            response.setStatus(SC_CREATED)

        } catch (Exception e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}