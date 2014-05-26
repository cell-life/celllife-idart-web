package org.celllife.idart.security.facility

import org.celllife.idart.application.facility.dto.FacilityDto
import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.facility.FacilityApplicationService

import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Named class FacilitySecurityAdapter {

    @Inject FacilityApplicationService facilityApplicationService

    FacilityId save(Principal principal, FacilityDto facilityDto) {
        facilityApplicationService.save(facilityDto)
    }
    
    List<FacilityDto> findAll() {
        facilityApplicationService.findAll()
    }

    FacilityDto findByFacilityId(Principal principal, FacilityId facilityId) {
        facilityApplicationService.findByFacilityId(facilityId)
    }

    FacilityDto findByIdentifier(Principal principal, Identifier identifier) {
        facilityApplicationService.findByIdentifier(identifier)
    }

}
