package org.celllife.idart.interfaces.resource.practitioner

import org.celllife.idart.application.practitioner.PractitionerApplicationService
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.common.PractitionerId
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
@Controller class PractitionerResourceController {

    @Autowired PractitionerApplicationService practitionerApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/practitioners/{practitionerId}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Practitioner findByPractitionerId(@PathVariable("practitionerId") PractitionerId practitionerId) {
        practitionerApplicationService.findByPractitionerId(practitionerId)
    }

    @RequestMapping(value = "/practitioners", method = RequestMethod.POST)
    void save(@RequestBody Practitioner practitioner, HttpServletResponse response) {

        practitioner = practitionerApplicationService.save(practitioner)

        response.setHeader("Location", "${baseUrl}/practitioners/${practitioner.id}")
        response.setStatus(SC_CREATED)
    }
}
