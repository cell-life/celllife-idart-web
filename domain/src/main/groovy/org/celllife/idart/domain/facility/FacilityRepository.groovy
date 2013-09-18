package org.celllife.idart.domain.facility

import org.celllife.idart.common.FacilityId


/**
 */
public interface FacilityRepository {

    boolean exists(FacilityId facilityId)

    Facility save(Facility facility)

    Facility findOne(FacilityId facilityId)

}
