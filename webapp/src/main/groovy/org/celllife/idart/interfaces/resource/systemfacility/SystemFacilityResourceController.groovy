package org.celllife.idart.interfaces.resource.systemfacility

import org.celllife.idart.application.systemfacility.dto.SystemFacilityDto
import org.celllife.idart.security.systemfacility.SystemFacilitySecurityAdapter
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
@Controller class SystemFacilityResourceController {

    @Inject SystemFacilitySecurityAdapter systemFacilitySecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @RequestMapping(value = "/systemFacility", method = RequestMethod.POST)
    void save(@RequestBody SystemFacilityDto systemFacilityDto, Principal principal, HttpServletResponse response) {

        try {

            systemFacilitySecurityAdapter.save(principal, systemFacilityDto)

            response.setStatus(SC_CREATED)

        } catch (Exception e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
