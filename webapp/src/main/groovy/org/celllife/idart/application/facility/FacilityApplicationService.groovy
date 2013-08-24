package org.celllife.idart.application.facility

import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.facility.FacilityValidationException
import org.celllife.idart.domain.facility.FacilityNotFoundException
import org.celllife.idart.common.FacilityId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface FacilityApplicationService {

    Facility save(Facility facility) throws FacilityValidationException

    Facility findByFacilityId(FacilityId facilityId) throws FacilityNotFoundException

}
