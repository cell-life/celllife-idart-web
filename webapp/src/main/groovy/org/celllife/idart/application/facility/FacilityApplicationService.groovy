package org.celllife.idart.application.facility

import org.celllife.idart.common.FacilityId
import org.celllife.idart.domain.facility.Facility

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface FacilityApplicationService {

    Facility save(Facility facility)

    Facility findByFacilityId(FacilityId facilityId)

}
