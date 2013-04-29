package org.celllife.idart.interfaces.service.doctor;

import org.celllife.idart.application.doctor.DoctorApplicationService;
import org.celllife.idart.domain.doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h16
 */
@Controller
@RequestMapping("/service/doctors")
public final class DoctorServiceController {

    @Autowired
    private DoctorApplicationService doctorApplicationService;

    @ResponseBody
    @RequestMapping(
            value = "/search/findByClinicIdentifier",
            method = RequestMethod.GET, produces = "application/json"
    )
    public List<Doctor> findByClinicIdentifier(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId,
                                               @RequestParam("clinicIdentifier") String clinicIdentifier) {

        return doctorApplicationService.findByClinicIdentifier(applicationId, clinicIdentifier);
    }
}
