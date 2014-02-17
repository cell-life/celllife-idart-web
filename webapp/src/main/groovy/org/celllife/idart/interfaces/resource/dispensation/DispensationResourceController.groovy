package org.celllife.idart.interfaces.resource.dispensation

import org.celllife.idart.common.DispensationId
import org.celllife.idart.application.dispensation.dto.DispensationDto
import org.celllife.idart.domain.dispensation.DispensationNotFoundException
import org.celllife.idart.domain.dispensation.DispensationValidationException
import org.celllife.idart.security.dispensation.DispensationSecurityAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

import javax.inject.Inject
import javax.servlet.http.HttpServletResponse
import java.security.Principal

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND

/**
 */
@Controller class DispensationResourceController {
    
    static final Logger LOGGER = LoggerFactory.getLogger(DispensationResourceController)

    @Inject DispensationSecurityAdapter dispensationSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/dispensations/{dispensationId}", method = RequestMethod.GET, produces = "application/json")
    DispensationDto findByDispensationId(@PathVariable("dispensationId") DispensationId dispensationId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return dispensationSecurityAdapter.findByDispensationId(principal, dispensationId)

        } catch (DispensationNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/dispensations", method = RequestMethod.POST)
    void save(@RequestBody DispensationDto dispensationDto, Principal principal, HttpServletResponse response) {

        try {

            DispensationId dispensationId = dispensationSecurityAdapter.save(principal, dispensationDto)

            response.setHeader("Location", "${baseUrl}/dispensations/${dispensationId}")
            response.setStatus(SC_CREATED)

        } catch (DispensationValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }

    @ResponseBody
    @RequestMapping(value = "/dispensations/deleteByIdentifier", method = RequestMethod.DELETE)
    void deleteByIdentifier(@RequestParam("identifier") String identifier, Principal principal,
                                              HttpServletResponse response) {

        try {

            LOGGER.info("About to delete dispensation with identifier="+identifier);
            dispensationSecurityAdapter.deleteByIdentifier(principal, identifier)
            response.setStatus(SC_OK)

        } catch (DispensationNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }
    
    @ResponseBody
    @RequestMapping(value = "/dispensations/{dispensationId}", method = RequestMethod.DELETE)
    void delete(@PathVariable("dispensationId") DispensationId dispensationId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            dispensationSecurityAdapter.deleteByDispensationId(principal, dispensationId)
            response.setStatus(SC_OK)

        } catch (DispensationNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }
}
