package org.celllife.idart.interfaces.resource.patient

import org.celllife.idart.application.patient.PatientApplicationService
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.common.PatientIdentifier
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

    @Autowired PatientApplicationService patientApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/patients/{patientIdentifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Patient findByPatientIdentifier(@PathVariable("patientIdentifier") PatientIdentifier patientIdentifier) {
        patientApplicationService.findByPatientIdentifier(patientIdentifier)
    }

    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    void save(@RequestBody Patient patient, HttpServletResponse response) {

        patient = patientApplicationService.save(patient)

        response.setHeader("Location", "${baseUrl}/patients/${patient.identifier}")
        response.setStatus(SC_CREATED)
    }
}
