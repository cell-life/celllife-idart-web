package org.celllife.idart.interfaces.resource.lifeevent

import org.celllife.idart.common.LifeEventCode
import org.celllife.idart.application.lifeevent.dto.LifeEventDto
import org.celllife.idart.domain.lifeevent.LifeEventNotFoundException
import org.celllife.idart.domain.lifeevent.LifeEventValidationException
import org.celllife.idart.security.lifeevent.LifeEventSecurityAdapter
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
@Controller class LifeEventResourceController {

    @Inject LifeEventSecurityAdapter lifeEventSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/lifeEvents/{lifeEventCode}", method = RequestMethod.GET, produces = "application/json")
    LifeEventDto findByLifeEventCode(@PathVariable("lifeEventCode") LifeEventCode lifeEventCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return lifeEventSecurityAdapter.findByLifeEventCode(principal, lifeEventCode)

        } catch (LifeEventNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/lifeEvents", method = RequestMethod.POST)
    void save(@RequestBody LifeEventDto lifeEventDto, Principal principal, HttpServletResponse response) {

        try {

            LifeEventCode lifeEventCode = lifeEventSecurityAdapter.save(principal, lifeEventDto)

            response.setHeader("Location", "${baseUrl}/lifeEvents/${lifeEventCode}")
            response.setStatus(SC_CREATED)

        } catch (LifeEventValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
