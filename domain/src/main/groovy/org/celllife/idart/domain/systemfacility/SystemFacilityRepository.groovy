package org.celllife.idart.domain.systemfacility

import org.celllife.idart.common.FacilityIdentifier
import org.celllife.idart.common.SystemIdentifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 21h14
 */
interface SystemFacilityRepository {

    SystemFacility save(SystemFacility userForSystem)

    SystemFacility findBySystemAndFacilityAndRelationship(
            SystemIdentifier systemIdentifier,
            FacilityIdentifier facilityIdentifier,
            SystemFacilityRelationship relationship)
}
