package org.celllife.idart.relationship.systemfacility

import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.SystemId

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h04
 */
public interface SystemFacilityService {

    void save(SystemFacility systemFacility)

    void save(SystemId system, FacilityId facility, SystemFacility.Relationship relationship)

    FacilityId findFacility(SystemId system, SystemFacility.Relationship relationship)

    SystemId findSystem(FacilityId facilityId, SystemFacility.Relationship relationship)
}