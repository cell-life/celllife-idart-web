package org.celllife.idart.interfaces.resource.compound

import org.celllife.idart.application.compound.CompoundApplicationService
import org.celllife.idart.domain.compound.Compound
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
@Controller class CompoundResourceController {

    @Autowired CompoundApplicationService compoundApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/compounds/{partId}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Compound findByPartId(@PathVariable("partId") PartId partId) {
        compoundApplicationService.findByPartId(partId)
    }

    @RequestMapping(value = "/compounds", method = RequestMethod.POST)
    void save(@RequestBody Compound compound, HttpServletResponse response) {

        compound = compoundApplicationService.save(compound)

        response.setHeader("Location", "${baseUrl}/compounds/${compound.id}")
        response.setStatus(SC_CREATED)
    }
}
