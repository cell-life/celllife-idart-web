package org.celllife.idart.interfaces.service.patient

import org.celllife.idart.application.patient.PatientApplicationService
import org.celllife.idart.domain.patient.Patient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_OK

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h16
 */
@Controller class PatientServiceController {

    @Autowired PatientApplicationService patientApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/service/patients/search/findByIdentifier",
            method = RequestMethod.GET, produces = "application/json"
    )
    List<Patient> findByIdentifier(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId,
                                   @RequestParam("clinicIdentifier") String clinicIdentifier,
                                   @RequestParam("patientIdentifier") String patientIdentifier) {

        patientApplicationService.findByIdentifier(applicationId, clinicIdentifier, patientIdentifier)
    }

    @RequestMapping(
            value = "/service/patients",
            method = RequestMethod.POST, produces = "application/json"
    )
    void save(@RequestBody Patient patient, HttpServletResponse response) {

        patient = patientApplicationService.save(patient)

        response.setHeader("Location", "${baseUrl}/service/patients/${patient.pk}")
        response.setStatus(SC_OK)
    }
}
