package org.celllife.idart.interfaces.service.prescription

import org.celllife.idart.application.prescription.PrescriptionResourceService
import org.celllife.idart.domain.prescription.Prescription
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
@Controller class PrescriptionResourceController {

    @Autowired PrescriptionResourceService prescriptionResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/prescriptions",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<Prescription> findAll(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        prescriptionResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/prescriptions/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Prescription findByIdentifier(@PathVariable("coidentifierde") String identifier, @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        prescriptionResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/prescriptions", method = RequestMethod.POST)
    void save(@RequestBody Prescription prescription, HttpServletResponse response) {

        prescription = prescriptionResourceService.save(prescription)

        response.setHeader("Location", "${baseUrl}/service/prescriptions/${prescription.pk}")
        response.setStatus(SC_CREATED)
    }
}
