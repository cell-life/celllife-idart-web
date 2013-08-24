package org.celllife.idart.interfaces.resource.facility

import org.celllife.idart.application.facility.FacilityApplicationService
import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.common.FacilityId
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
@Controller class FacilityResourceController {

    @Autowired FacilityApplicationService facilityApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/facilities/{facilityId}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Facility findByFacilityId(@PathVariable("facilityId") FacilityId facilityId) {
        facilityApplicationService.findByFacilityId(facilityId)
    }

    @RequestMapping(value = "/facilities", method = RequestMethod.POST)
    void save(@RequestBody Facility facility, HttpServletResponse response) {

        facility = facilityApplicationService.save(facility)

        response.setHeader("Location", "${baseUrl}/facilitys/${facility.id}")
        response.setStatus(SC_CREATED)
    }
}
