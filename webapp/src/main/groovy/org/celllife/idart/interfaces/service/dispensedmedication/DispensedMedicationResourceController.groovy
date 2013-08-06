package org.celllife.idart.interfaces.service.dispensedmedication

import org.celllife.idart.application.dispensedmedication.DispensedMedicationResourceService
import org.celllife.idart.domain.dispensedmedication.DispensedMedication
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

    @Autowired DispensedMedicationResourceService dispensedMedicationResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/dispensedMedications",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<DispensedMedication> findAll() {
        dispensedMedicationResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/dispensedMedications/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    DispensedMedication findByIdentifier(@PathVariable("identifier") String identifier) {
        dispensedMedicationResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/dispensedMedications", method = RequestMethod.POST)
    void save(@RequestBody DispensedMedication dispensedMedication, HttpServletResponse response) {

        dispensedMedication = dispensedMedicationResourceService.save(dispensedMedication)

        response.setHeader("Location", "${baseUrl}/dispensedMedications/${dispensedMedication.pk}")
        response.setStatus(SC_CREATED)
    }
}
