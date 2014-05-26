package org.celllife.idart.domain.facility

import org.celllife.idart.common.FacilityId


/**
 */
public interface FacilityService {

    Boolean exists(FacilityId facilityId)

    Facility save(Facility facility)
    
    List<Facility> findAll()

    Facility findByFacilityId(FacilityId facilityId)

}
