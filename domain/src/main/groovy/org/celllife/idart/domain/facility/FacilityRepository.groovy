package org.celllife.idart.domain.facility

import org.celllife.idart.common.FacilityId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface FacilityRepository {

    Facility save(Facility facility)

    Facility findOne(FacilityId facilityId)

}
