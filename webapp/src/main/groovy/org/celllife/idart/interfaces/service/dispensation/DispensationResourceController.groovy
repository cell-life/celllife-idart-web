package org.celllife.idart.interfaces.service.dispensation

import org.celllife.idart.application.dispensation.DispensationResourceService
import org.celllife.idart.domain.dispensation.Dispensation
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

    @Autowired DispensationResourceService dispensationResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/dispensations",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<Dispensation> findAll() {
        dispensationResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/dispensations/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Dispensation findByIdentifier(@PathVariable("identifier") String identifier) {
        dispensationResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/dispensations", method = RequestMethod.POST)
    void save(@RequestBody Dispensation dispensation, HttpServletResponse response) {

        dispensation = dispensationResourceService.save(dispensation)

        response.setHeader("Location", "${baseUrl}/dispensations/${dispensation.pk}")
        response.setStatus(SC_CREATED)
    }
}
