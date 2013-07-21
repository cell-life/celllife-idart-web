package org.celllife.idart.interfaces.service.clinic

import org.celllife.idart.application.clinic.ClinicResourceService
import org.celllife.idart.domain.clinic.Clinic
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
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class ClinicResourceController {

    @Autowired ClinicResourceService clinicResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/clinics",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<Clinic> findAll(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        clinicResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/clinics/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Clinic findByIdentifier(@PathVariable("coidentifierde") String identifier, @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        clinicResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/clinics", method = RequestMethod.POST)
    void save(@RequestBody Clinic clinic, HttpServletResponse response) {

        clinic = clinicResourceService.save(clinic)

        response.setHeader("Location", "${baseUrl}/service/clinics/${clinic.pk}")
        response.setStatus(SC_CREATED)
    }
}