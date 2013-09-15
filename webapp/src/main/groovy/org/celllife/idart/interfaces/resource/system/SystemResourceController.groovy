package org.celllife.idart.interfaces.resource.system

import org.celllife.idart.common.SystemId
import org.celllife.idart.application.system.dto.SystemDto
import org.celllife.idart.domain.system.SystemNotFoundException
import org.celllife.idart.domain.system.SystemValidationException
import org.celllife.idart.security.system.SystemSecurityAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import javax.annotation.Generated
import javax.inject.Inject
import javax.servlet.http.HttpServletResponse
import java.security.Principal

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class SystemResourceController {

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

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/systems", method = RequestMethod.POST)
    void save(@RequestBody SystemDto systemDto, Principal principal, HttpServletResponse response) {

        try {

            SystemId systemId = systemSecurityAdapter.save(principal, systemDto)

            response.setHeader("Location", "${baseUrl}/systemss/${systemId}")
            response.setStatus(SC_CREATED)

        } catch (SystemValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
