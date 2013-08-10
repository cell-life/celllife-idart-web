package org.celllife.idart.domain.systemfacility

import org.celllife.idart.domain.facility.FacilityIdentifier
import org.celllife.idart.domain.system.SystemIdentifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 22h35
 */
interface SystemFacilityService {

    void saveUserForSystem(SystemIdentifier systemIdentifier, FacilityIdentifier facilityIdentifier)

}