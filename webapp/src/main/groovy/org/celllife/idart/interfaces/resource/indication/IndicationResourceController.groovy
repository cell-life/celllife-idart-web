package org.celllife.idart.interfaces.resource.indication

import org.celllife.idart.application.indication.IndicationApplicationService
import org.celllife.idart.domain.indication.Indication
import org.celllife.idart.domain.indication.IndicationCode
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
@Controller class IndicationResourceController {

    @Autowired IndicationApplicationService indicationApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/indications/{code}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Indication findByCode(@PathVariable("code") IndicationCode code) {
        indicationApplicationService.findByCode(code)
    }

    @RequestMapping(value = "/indications", method = RequestMethod.POST)
    void save(@RequestBody Indication indication, HttpServletResponse response) {

        indication = indicationApplicationService.save(indication)

        response.setHeader("Location", "${baseUrl}/indications/${indication.code}")
        response.setStatus(SC_CREATED)
    }
}
