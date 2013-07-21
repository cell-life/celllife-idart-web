package org.celllife.idart.interfaces.service.part

import org.celllife.idart.application.part.DrugResourceService
import org.celllife.idart.domain.part.Drug
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.annotation.Generated
import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_CREATED

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h36
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
    Iterable<Drug> findAll(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        drugResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/drugs/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Drug findByIdentifier(@PathVariable("coidentifierde") String identifier, @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        drugResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/drugs", method = RequestMethod.POST)
    void save(@RequestBody Drug drug, HttpServletResponse response) {

        drug = drugResourceService.save(drug)

        response.setHeader("Location", "${baseUrl}/service/drugs/${drug.pk}")
        response.setStatus(SC_CREATED)
    }
}
