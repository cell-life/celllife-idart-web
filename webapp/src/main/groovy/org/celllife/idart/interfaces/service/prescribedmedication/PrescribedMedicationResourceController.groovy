package org.celllife.idart.interfaces.service.prescribedmedication

import org.celllife.idart.application.prescribedmedication.PrescribedMedicationResourceService
import org.celllife.idart.domain.prescribedmedication.PrescribedMedication
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

    @Autowired PrescribedMedicationResourceService prescribedMedicationResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/prescribedMedications",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<PrescribedMedication> findAll() {
        prescribedMedicationResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/prescribedMedications/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    PrescribedMedication findByIdentifier(@PathVariable("identifier") String identifier) {
        prescribedMedicationResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/prescribedMedications", method = RequestMethod.POST)
    void save(@RequestBody PrescribedMedication prescribedMedication, HttpServletResponse response) {

        prescribedMedication = prescribedMedicationResourceService.save(prescribedMedication)

        response.setHeader("Location", "${baseUrl}/prescribedMedications/${prescribedMedication.pk}")
        response.setStatus(SC_CREATED)
    }
}
