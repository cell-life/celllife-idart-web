package org.celllife.idart.domain.systemfacility

import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.SystemId

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 22h35
 */
interface SystemFacilityService {

    void saveUserForSystem(SystemId systemId, FacilityId facilityId)

}
