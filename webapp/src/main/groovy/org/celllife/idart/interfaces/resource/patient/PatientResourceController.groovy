package org.celllife.idart.interfaces.resource.patient

import org.celllife.idart.application.patient.PatientApplicationService
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.common.PatientId
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
            value = "/patients/{patientId}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Patient findByPatientId(@PathVariable("patientId") PatientId patientId) {
        patientApplicationService.findByPatientId(patientId)
    }

    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    void save(@RequestBody Patient patient, HttpServletResponse response) {

        patient = patientApplicationService.save(patient)

        response.setHeader("Location", "${baseUrl}/patients/${patient.id}")
        response.setStatus(SC_CREATED)
    }
}
