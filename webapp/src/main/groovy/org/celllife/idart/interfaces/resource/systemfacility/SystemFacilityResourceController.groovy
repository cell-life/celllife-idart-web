package org.celllife.idart.interfaces.resource.systemfacility

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED

import java.security.Principal

import javax.inject.Inject
import javax.servlet.http.HttpServletResponse

import org.celllife.idart.application.systemfacility.dto.SystemFacilityDto
import org.celllife.idart.security.systemfacility.SystemFacilitySecurityAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 */
@Controller class SystemFacilityResourceController {

    static final Logger LOGGER = LoggerFactory.getLogger(SystemFacilityResourceController)

    @Inject SystemFacilitySecurityAdapter systemFacilitySecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @RequestMapping(value = "/systemFacility", method = RequestMethod.POST)
    void save(@RequestBody SystemFacilityDto systemFacilityDto, Principal principal, HttpServletResponse response) {

        try {

            systemFacilitySecurityAdapter.save(principal, systemFacilityDto)

            response.setStatus(SC_CREATED)

        } catch (Exception e) {
            LOGGER.error("Could not save SystemFacility "+systemFacilityDto, e)
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
