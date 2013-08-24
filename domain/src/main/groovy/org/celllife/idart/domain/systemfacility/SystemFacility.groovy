package org.celllife.idart.domain.systemfacility

import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.SystemId

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 20h59
 */
class SystemFacility {

    Long pk

    SystemId fromSystem

    FacilityId toFacility

    SystemFacilityRelationship relationship

}
