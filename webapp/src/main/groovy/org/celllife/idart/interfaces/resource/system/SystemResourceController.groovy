package org.celllife.idart.interfaces.resource.system

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND

import java.security.Principal

import javax.inject.Inject
import javax.servlet.http.HttpServletResponse

import org.celllife.idart.application.system.dto.SystemDto
import org.celllife.idart.common.SystemId
import org.celllife.idart.domain.system.SystemNotFoundException
import org.celllife.idart.domain.system.SystemValidationException
import org.celllife.idart.security.system.SystemSecurityAdapter
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
@Controller class SystemResourceController {

    static final Logger LOGGER = LoggerFactory.getLogger(SystemResourceController)

    @Inject SystemSecurityAdapter systemSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/systems/{systemId}", method = RequestMethod.GET, produces = "application/json")
    SystemDto findBySystemId(@PathVariable("systemId") SystemId systemId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return systemSecurityAdapter.findBySystemId(principal, systemId)

        } catch (SystemNotFoundException ignore) {
            LOGGER.error("Could not find System with id "+systemId, ignore)
            response.setStatus(SC_NOT_FOUND)
            return null
        }
    }

    @RequestMapping(value = "/systems", method = RequestMethod.POST)
    void save(@RequestBody SystemDto systemDto, Principal principal, HttpServletResponse response) {

        try {

            SystemId systemId = systemSecurityAdapter.save(principal, systemDto)

            response.setHeader("Location", "${baseUrl}/systems/${systemId}")
            response.setStatus(SC_CREATED)

        } catch (SystemValidationException e) {
            LOGGER.error("Could not save System "+systemDto, e)
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
