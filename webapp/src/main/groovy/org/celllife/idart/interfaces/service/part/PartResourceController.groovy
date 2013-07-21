package org.celllife.idart.interfaces.service.part

import org.celllife.idart.application.part.PartResourceService
import org.celllife.idart.domain.part.Part
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
@Controller class PartResourceController {

    @Autowired PartResourceService partResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/parts",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<Part> findAll(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        partResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/parts/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Part findByIdentifier(@PathVariable("coidentifierde") String identifier, @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        partResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/parts", method = RequestMethod.POST)
    void save(@RequestBody Part part, HttpServletResponse response) {

        part = partResourceService.save(part)

        response.setHeader("Location", "${baseUrl}/service/parts/${part.pk}")
        response.setStatus(SC_CREATED)
    }
}
