package org.celllife.idart.interfaces.service.practitioner

import org.celllife.idart.application.practitioner.PractitionerResourceService
import org.celllife.idart.domain.practitioner.Practitioner
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
 * Time: 22h33
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class PractitionerResourceController {

    @Autowired PractitionerResourceService practitionerResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/practitioners",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<Practitioner> findAll(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        practitionerResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/practitioners/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Practitioner findByIdentifier(@PathVariable("coidentifierde") String identifier, @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        practitionerResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/practitioners", method = RequestMethod.POST)
    void save(@RequestBody Practitioner practitioner, HttpServletResponse response) {

        practitioner = practitionerResourceService.save(practitioner)

        response.setHeader("Location", "${baseUrl}/service/practitioners/${practitioner.pk}")
        response.setStatus(SC_CREATED)
    }
}
