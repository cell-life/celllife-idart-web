package org.celllife.idart.interfaces.service.patient;

import org.celllife.idart.application.patient.FindPatientsByIdentifierResponse;
import org.celllife.idart.application.patient.PatientApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h16
 */
@Controller
@RequestMapping("/service/patients")
public final class PatientServiceController {

    @Autowired
    private PatientApplicationService patientApplicationService;

    @ResponseBody
    @RequestMapping(
            value = "/search/findByIdentifier",
            method = RequestMethod.GET, produces = "application/json"
    )
    public FindPatientsByIdentifierResponse findByIdentifier(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId,
                                                             @ModelAttribute FindPatientsByIdentifierRequest request) {

        return patientApplicationService.findByIdentifier(request);
    }
}
