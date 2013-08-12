package org.celllife.idart.interfaces.resource.prescribedmedication

import org.celllife.idart.application.prescribedmedication.PrescribedMedicationApplicationService
import org.celllife.idart.domain.prescribedmedication.PrescribedMedication
import org.celllife.idart.common.PrescribedMedicationIdentifier
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
@Controller class PrescribedMedicationResourceController {

    @Autowired PrescribedMedicationApplicationService prescribedMedicationApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/prescribedMedications/{prescribedMedicationIdentifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    PrescribedMedication findByPrescribedMedicationIdentifier(@PathVariable("prescribedMedicationIdentifier") PrescribedMedicationIdentifier prescribedMedicationIdentifier) {
        prescribedMedicationApplicationService.findByPrescribedMedicationIdentifier(prescribedMedicationIdentifier)
    }

    @RequestMapping(value = "/prescribedMedications", method = RequestMethod.POST)
    void save(@RequestBody PrescribedMedication prescribedMedication, HttpServletResponse response) {

        prescribedMedication = prescribedMedicationApplicationService.save(prescribedMedication)

        response.setHeader("Location", "${baseUrl}/prescribedMedications/${prescribedMedication.identifier}")
        response.setStatus(SC_CREATED)
    }
}
