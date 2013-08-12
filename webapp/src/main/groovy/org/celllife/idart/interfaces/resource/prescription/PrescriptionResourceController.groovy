package org.celllife.idart.interfaces.resource.prescription

import org.celllife.idart.application.prescription.PrescriptionApplicationService
import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.common.PrescriptionIdentifier
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
@Controller class PrescriptionResourceController {

    @Autowired PrescriptionApplicationService prescriptionApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/prescriptions/{prescriptionIdentifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Prescription findByPrescriptionIdentifier(@PathVariable("prescriptionIdentifier") PrescriptionIdentifier prescriptionIdentifier) {
        prescriptionApplicationService.findByPrescriptionIdentifier(prescriptionIdentifier)
    }

    @RequestMapping(value = "/prescriptions", method = RequestMethod.POST)
    void save(@RequestBody Prescription prescription, HttpServletResponse response) {

        prescription = prescriptionApplicationService.save(prescription)

        response.setHeader("Location", "${baseUrl}/prescriptions/${prescription.identifier}")
        response.setStatus(SC_CREATED)
    }
}
