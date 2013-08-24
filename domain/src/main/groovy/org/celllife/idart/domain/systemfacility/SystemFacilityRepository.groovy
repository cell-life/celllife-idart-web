package org.celllife.idart.domain.systemfacility

import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.SystemId

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 21h14
 */
interface SystemFacilityRepository {

    SystemFacility save(SystemFacility userForSystem)

    SystemFacility findBySystemAndFacilityAndRelationship(
            SystemId systemId,
            FacilityId facilityId,
            SystemFacilityRelationship relationship)
}
