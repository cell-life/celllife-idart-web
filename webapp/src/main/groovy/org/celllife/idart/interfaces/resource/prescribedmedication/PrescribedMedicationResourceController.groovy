package org.celllife.idart.interfaces.resource.prescribedmedication

import org.celllife.idart.common.PrescribedMedicationId
import org.celllife.idart.domain.prescribedmedication.PrescribedMedication
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationNotFoundException
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationValidationException
import org.celllife.idart.security.prescribedmedication.PrescribedMedicationSecurityAdapter
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
@Controller class PrescribedMedicationResourceController {

    @Inject PrescribedMedicationSecurityAdapter prescribedMedicationSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/prescribedMedications/{prescribedMedicationId}", method = GET, produces = "application/json")
    PrescribedMedication findByPrescribedMedicationId(@PathVariable("prescribedMedicationId") PrescribedMedicationId prescribedMedicationId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            prescribedMedicationSecurityAdapter.findByPrescribedMedicationId(principal, prescribedMedicationId)

        } catch (PrescribedMedicationNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/prescribedMedications", method = POST)
    void save(@RequestBody PrescribedMedication prescribedMedication, Principal principal, HttpServletResponse response) {

        try {

            prescribedMedication = prescribedMedicationSecurityAdapter.save(principal, prescribedMedication)

            response.setHeader("Location", "${baseUrl}/prescribedMedications/${prescribedMedication.id}")
            response.setStatus(SC_CREATED)

        } catch (PrescribedMedicationValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
