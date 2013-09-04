package org.celllife.idart.interfaces.resource.prescription

import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.prescription.PrescriptionNotFoundException
import org.celllife.idart.domain.prescription.PrescriptionValidationException
import org.celllife.idart.security.prescription.PrescriptionSecurityAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import javax.annotation.Generated
import javax.inject.Inject
import javax.servlet.http.HttpServletResponse
import java.security.Principal

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND
import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class PrescriptionResourceController {

    @Inject PrescriptionSecurityAdapter prescriptionSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/prescriptions/{prescriptionId}", method = GET, produces = "application/json")
    Prescription findByPrescriptionId(@PathVariable("prescriptionId") PrescriptionId prescriptionId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            prescriptionSecurityAdapter.findByPrescriptionId(principal, prescriptionId)

        } catch (PrescriptionNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/prescriptions", method = POST)
    void save(@RequestBody Prescription prescription, Principal principal, HttpServletResponse response) {

        try {

            prescription = prescriptionSecurityAdapter.save(principal, prescription)

            response.setHeader("Location", "${baseUrl}/prescriptions/${prescription.id}")
            response.setStatus(SC_CREATED)

        } catch (PrescriptionValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
