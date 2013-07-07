package org.celllife.idart.interfaces.service.patient

import org.celllife.idart.application.patient.FindPatientsByIdentifierResponse
import org.celllife.idart.application.patient.PatientApplicationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h16
 */
@Controller class PatientServiceController {

    @Autowired PatientApplicationService patientApplicationService

    @ResponseBody
    @RequestMapping(
            value = "/service/patients/search/findByIdentifier",
            method = RequestMethod.GET, produces = "application/json"
    )
    FindPatientsByIdentifierResponse findByIdentifier(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId,
                                                      @ModelAttribute FindPatientsByIdentifierRequest request) {

        patientApplicationService.findByIdentifier(request)
    }
}
