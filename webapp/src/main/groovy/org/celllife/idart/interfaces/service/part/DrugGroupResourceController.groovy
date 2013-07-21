package org.celllife.idart.interfaces.service.part

import org.celllife.idart.application.part.DrugGroupResourceService
import org.celllife.idart.domain.part.DrugGroup
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
 * Time: 03h45
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class DrugGroupResourceController {

    @Autowired DrugGroupResourceService drugGroupResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/drugGroups",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<DrugGroup> findAll(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        drugGroupResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/drugGroups/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    DrugGroup findByIdentifier(@PathVariable("coidentifierde") String identifier, @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        drugGroupResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/drugGroups", method = RequestMethod.POST)
    void save(@RequestBody DrugGroup drugGroup, HttpServletResponse response) {

        drugGroup = drugGroupResourceService.save(drugGroup)

        response.setHeader("Location", "${baseUrl}/service/drugGroups/${drugGroup.pk}")
        response.setStatus(SC_CREATED)
    }
}
