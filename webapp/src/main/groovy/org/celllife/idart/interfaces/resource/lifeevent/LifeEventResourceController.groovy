package org.celllife.idart.interfaces.resource.lifeevent

import org.celllife.idart.application.lifeevent.LifeEventApplicationService
import org.celllife.idart.domain.lifeevent.LifeEvent
import org.celllife.idart.common.LifeEventCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.annotation.Generated
import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_CREATED

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class LifeEventResourceController {

    @Autowired LifeEventApplicationService lifeEventApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/lifeEvents/{lifeEventCode}",
            method = RequestMethod.GET, produces = "application/json"
    )
    LifeEvent findByLifeEventCode(@PathVariable("lifeEventCode") LifeEventCode lifeEventCode) {
        lifeEventApplicationService.findByLifeEventCode(lifeEventCode)
    }

    @RequestMapping(value = "/lifeEvents", method = RequestMethod.POST)
    void save(@RequestBody LifeEvent lifeEvent, HttpServletResponse response) {

        lifeEvent = lifeEventApplicationService.save(lifeEvent)

        response.setHeader("Location", "${baseUrl}/lifeEvents/${lifeEvent.code}")
        response.setStatus(SC_CREATED)
    }
}
