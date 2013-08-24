package org.celllife.idart.interfaces.resource.part

import org.celllife.idart.application.part.PartApplicationService
import org.celllife.idart.domain.part.Part
import org.celllife.idart.common.PartId
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
@Controller class PartResourceController {

    @Autowired PartApplicationService partApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/parts/{partId}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Part findByPartId(@PathVariable("partId") PartId partId) {
        partApplicationService.findByPartId(partId)
    }

    @RequestMapping(value = "/parts", method = RequestMethod.POST)
    void save(@RequestBody Part part, HttpServletResponse response) {

        part = partApplicationService.save(part)

        response.setHeader("Location", "${baseUrl}/parts/${part.id}")
        response.setStatus(SC_CREATED)
    }
}
