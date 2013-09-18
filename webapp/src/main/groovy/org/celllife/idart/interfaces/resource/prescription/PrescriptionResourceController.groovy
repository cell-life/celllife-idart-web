package org.celllife.idart.interfaces.resource.prescription

import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.application.prescription.dto.PrescriptionDto
import org.celllife.idart.domain.prescription.PrescriptionNotFoundException
import org.celllife.idart.domain.prescription.PrescriptionValidationException
import org.celllife.idart.security.prescription.PrescriptionSecurityAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import javax.inject.Inject
import javax.servlet.http.HttpServletResponse
import java.security.Principal

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND

/**
 */
@Controller class PrescriptionResourceController {

    @Inject PrescriptionSecurityAdapter prescriptionSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/prescriptions/{prescriptionId}", method = RequestMethod.GET, produces = "application/json")
    PrescriptionDto findByPrescriptionId(@PathVariable("prescriptionId") PrescriptionId prescriptionId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return prescriptionSecurityAdapter.findByPrescriptionId(principal, prescriptionId)

        } catch (PrescriptionNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/prescriptions", method = RequestMethod.POST)
    void save(@RequestBody PrescriptionDto prescriptionDto, Principal principal, HttpServletResponse response) {

        try {

            PrescriptionId prescriptionId = prescriptionSecurityAdapter.save(principal, prescriptionDto)

            response.setHeader("Location", "${baseUrl}/prescriptions/${prescriptionId}")
            response.setStatus(SC_CREATED)

        } catch (PrescriptionValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
