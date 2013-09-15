package org.celllife.idart.security.facility

import org.celllife.idart.application.facility.dto.FacilityDto
import org.celllife.idart.common.FacilityId
import org.celllife.idart.domain.identifiable.Identifier
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

    FacilityId save(Principal principal, facilityDto) {
        facilityApplicationService.save(facilityDto)
    }

    FacilityDto findByFacilityId(Principal principal, FacilityId facilityId) {
        facilityApplicationService.findByFacilityId(facilityId)
    }

    FacilityDto findByIdentifier(Principal principal, Identifier identifier) {
        facilityApplicationService.findByIdentifier(identifier)
    }

}
