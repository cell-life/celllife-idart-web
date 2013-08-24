package org.celllife.idart.interfaces.resource.drug

import org.celllife.idart.application.drug.DrugApplicationService
import org.celllife.idart.domain.drug.Drug
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
@Controller class DrugResourceController {

    @Autowired DrugApplicationService drugApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/drugs/{partId}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Drug findByPartId(@PathVariable("partId") PartId partId) {
        drugApplicationService.findByPartId(partId)
    }

    @RequestMapping(value = "/drugs", method = RequestMethod.POST)
    void save(@RequestBody Drug drug, HttpServletResponse response) {

        drug = drugApplicationService.save(drug)

        response.setHeader("Location", "${baseUrl}/drugs/${drug.id}")
        response.setStatus(SC_CREATED)
    }
}
