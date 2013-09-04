package org.celllife.idart.interfaces.resource.lifeevent

import org.celllife.idart.common.LifeEventCode
import org.celllife.idart.domain.lifeevent.LifeEvent
import org.celllife.idart.domain.lifeevent.LifeEventNotFoundException
import org.celllife.idart.domain.lifeevent.LifeEventValidationException
import org.celllife.idart.security.lifeevent.LifeEventSecurityAdapter
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
@Controller class LifeEventResourceController {

    @Inject LifeEventSecurityAdapter lifeEventSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/lifeEvents/{lifeEventCode}", method = GET, produces = "application/json")
    LifeEvent findByLifeEventCode(@PathVariable("lifeEventCode") LifeEventCode lifeEventCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            lifeEventSecurityAdapter.findByLifeEventCode(principal, lifeEventCode)

        } catch (LifeEventNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/lifeEvents", method = POST)
    void save(@RequestBody LifeEvent lifeEvent, Principal principal, HttpServletResponse response) {

        try {

            lifeEvent = lifeEventSecurityAdapter.save(principal, lifeEvent)

            response.setHeader("Location", "${baseUrl}/lifeEvents/${lifeEvent.code}")
            response.setStatus(SC_CREATED)

        } catch (LifeEventValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
