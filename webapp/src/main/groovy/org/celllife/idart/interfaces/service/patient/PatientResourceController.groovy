package org.celllife.idart.interfaces.service.patient

import org.celllife.idart.application.patient.PatientResourceService
import org.celllife.idart.domain.patient.Patient
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
@Controller class PatientResourceController {

    @Autowired PatientResourceService patientResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/patients",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<Patient> findAll() {
        patientResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/patients/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Patient findByIdentifier(@PathVariable("identifier") String identifier) {
        patientResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    void save(@RequestBody Patient patient, HttpServletResponse response) {

        patient = patientResourceService.save(patient)

        response.setHeader("Location", "${baseUrl}/patients/${patient.pk}")
        response.setStatus(SC_CREATED)
    }
}
