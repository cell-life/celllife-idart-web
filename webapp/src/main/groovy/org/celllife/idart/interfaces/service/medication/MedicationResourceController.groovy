package org.celllife.idart.interfaces.service.medication

import org.celllife.idart.application.medication.MedicationResourceService
import org.celllife.idart.domain.medication.Medication
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
@Controller class MedicationResourceController {

    @Autowired MedicationResourceService medicationResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/medications",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<Medication> findAll() {
        medicationResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/medications/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Medication findByIdentifier(@PathVariable("identifier") String identifier) {
        medicationResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/medications", method = RequestMethod.POST)
    void save(@RequestBody Medication medication, HttpServletResponse response) {

        medication = medicationResourceService.save(medication)

        response.setHeader("Location", "${baseUrl}/medications/${medication.pk}")
        response.setStatus(SC_CREATED)
    }
}
