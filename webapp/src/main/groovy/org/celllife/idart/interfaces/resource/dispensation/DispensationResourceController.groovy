package org.celllife.idart.interfaces.resource.dispensation

import org.celllife.idart.application.dispensation.DispensationApplicationService
import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.common.DispensationId
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
@Controller class DispensationResourceController {

    @Autowired DispensationApplicationService dispensationApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/dispensations/{dispensationId}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Dispensation findByDispensationId(@PathVariable("dispensationId") DispensationId dispensationId) {
        dispensationApplicationService.findByDispensationId(dispensationId)
    }

    @RequestMapping(value = "/dispensations", method = RequestMethod.POST)
    void save(@RequestBody Dispensation dispensation, HttpServletResponse response) {

        dispensation = dispensationApplicationService.save(dispensation)

        response.setHeader("Location", "${baseUrl}/dispensations/${dispensation.id}")
        response.setStatus(SC_CREATED)
    }
}
