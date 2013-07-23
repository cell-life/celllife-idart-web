package org.celllife.idart.interfaces.service.drug

import org.celllife.idart.application.drug.DrugResourceService
import org.celllife.idart.domain.drug.Drug
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.annotation.Generated
import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_CREATED

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class DrugResourceController {

    @Autowired DrugResourceService drugResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/drugs",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<Drug> findAll() {
        drugResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/drugs/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Drug findByIdentifier(@PathVariable("coidentifierde") String identifier) {
        drugResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/drugs", method = RequestMethod.POST)
    void save(@RequestBody Drug drug, HttpServletResponse response) {

        drug = drugResourceService.save(drug)

        response.setHeader("Location", "${baseUrl}/drugs/${drug.pk}")
        response.setStatus(SC_CREATED)
    }
}
