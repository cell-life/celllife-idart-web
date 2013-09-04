package org.celllife.idart.security.facility

import org.celllife.idart.common.FacilityId
import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.application.facility.FacilityApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class FacilitySecurityAdapter {

    @Inject FacilityApplicationService facilityApplicationService

    Facility save(Principal principal, Facility facility) {
        facilityApplicationService.save(facility)
    }

    Facility findByFacilityId(Principal principal, FacilityId facilityId) {
        facilityApplicationService.findByFacilityId(facilityId)
    }

}
