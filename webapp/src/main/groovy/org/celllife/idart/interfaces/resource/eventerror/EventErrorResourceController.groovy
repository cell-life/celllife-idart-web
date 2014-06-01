package org.celllife.idart.interfaces.resource.eventerror

import static javax.servlet.http.HttpServletResponse.SC_OK
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND

import java.security.Principal

import javax.inject.Inject
import javax.servlet.http.HttpServletResponse

import org.celllife.idart.application.eventerror.EventErrorApplicationService
import org.celllife.idart.application.eventerror.dto.EventErrorDto
import org.celllife.idart.common.DispensationId;
import org.celllife.idart.domain.eventerror.EventErrorNotFoundException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 */
@Controller class EventErrorResourceController {

    static final Logger LOGGER = LoggerFactory.getLogger(EventErrorResourceController)

    @Inject EventErrorApplicationService eventErrorService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/eventerrors/{eventErrorId}", method = RequestMethod.GET, produces = "application/json")
    EventErrorDto findByEventErrorId(@PathVariable("eventErrorId") Long eventErrorId,
            Principal principal,
            HttpServletResponse response) {

        try {
            return eventErrorService.findByEventErrorId(eventErrorId)
        } catch (EventErrorNotFoundException ignore) {
            response.setStatus(SC_NOT_FOUND)
            return null
        }
    }

    @ResponseBody
    @RequestMapping(value = "/eventerrors/{eventErrorId}/reprocess", method = RequestMethod.GET, produces = "application/json")
    EventErrorDto reprocess(@PathVariable("eventErrorId") Long eventErrorId,
            Principal principal,
            HttpServletResponse response) {

        try {
            List<Long> ids = new ArrayList<Long>()
            ids.add(eventErrorId)
            return eventErrorService.reprocess(ids)
        } catch (EventErrorNotFoundException ignore) {
            response.setStatus(SC_NOT_FOUND)
            return null
        }
    }

    @ResponseBody
    @RequestMapping(value = "/eventerrors", method = RequestMethod.GET, produces = "application/json")
    List<EventErrorDto> findAll(Principal principal, HttpServletResponse response) {
        return eventErrorService.findAll()
    }

    @ResponseBody
    @RequestMapping(value = "/eventerrors/{eventErrorId}", method = RequestMethod.DELETE)
    void delete(@PathVariable("eventErrorId")Long eventErrorId,
            Principal principal, HttpServletResponse response) {

        try {
            eventErrorService.delete(eventErrorId)
            response.setStatus(SC_OK)
        } catch (EventErrorNotFoundException ignore) {
            response.setStatus(SC_NOT_FOUND)
            return null
        }
    }
}
