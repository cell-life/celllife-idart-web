package org.celllife.idart.interfaces.service.practitioner

import org.celllife.idart.application.practitioner.PractitionerApplicationService
import org.celllife.idart.domain.practitioner.Practitioner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h16
 */
@Controller class PractitionerServiceController {

    @Autowired PractitionerApplicationService practitionerApplicationService

    @ResponseBody
    @RequestMapping(
            value = "/service/practitioners/search/findByClinicIdentifier",
            method = RequestMethod.GET, produces = "application/json"
    )
    List<Practitioner> findByClinicIdentifier(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId,
                                              @RequestParam("clinicIdentifier") String clinicIdentifier) {

        practitionerApplicationService.findByClinicIdentifier(applicationId, clinicIdentifier)
    }
}
