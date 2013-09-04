package org.celllife.idart.application.facility

import org.celllife.idart.common.FacilityId
import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.facility.FacilityService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class FacilityApplicationServiceImpl implements FacilityApplicationService {

    @Inject FacilityService facilityService

    Facility save(Facility facility) {
        facilityService.save(facility)
    }

    Facility findByFacilityId(FacilityId facilityId) {
        facilityService.findByFacilityId(facilityId)
    }

}
