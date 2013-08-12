package org.celllife.idart.interfaces.resource.dispensedmedication

import org.celllife.idart.application.dispensedmedication.DispensedMedicationApplicationService
import org.celllife.idart.domain.dispensedmedication.DispensedMedication
import org.celllife.idart.common.DispensedMedicationIdentifier
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
@Controller class DispensedMedicationResourceController {

    @Autowired DispensedMedicationApplicationService dispensedMedicationApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/dispensedMedications/{dispensedMedicationIdentifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    DispensedMedication findByDispensedMedicationIdentifier(@PathVariable("dispensedMedicationIdentifier") DispensedMedicationIdentifier dispensedMedicationIdentifier) {
        dispensedMedicationApplicationService.findByDispensedMedicationIdentifier(dispensedMedicationIdentifier)
    }

    @RequestMapping(value = "/dispensedMedications", method = RequestMethod.POST)
    void save(@RequestBody DispensedMedication dispensedMedication, HttpServletResponse response) {

        dispensedMedication = dispensedMedicationApplicationService.save(dispensedMedication)

        response.setHeader("Location", "${baseUrl}/dispensedMedications/${dispensedMedication.identifier}")
        response.setStatus(SC_CREATED)
    }
}
