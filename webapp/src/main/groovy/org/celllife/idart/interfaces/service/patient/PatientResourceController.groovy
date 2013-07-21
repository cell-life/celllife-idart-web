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
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 01h42
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class PatientResourceController {

    @Autowired PatientResourceService patientResourceService

    @Value('${external.base.url}') String baseUrl

    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    void save(@RequestBody Patient patient, HttpServletResponse response) {

        patient = patientResourceService.save(patient)

        response.setHeader("Location", "${baseUrl}/service/patients/${patient.pk}")
        response.setStatus(SC_CREATED)
    }
}
