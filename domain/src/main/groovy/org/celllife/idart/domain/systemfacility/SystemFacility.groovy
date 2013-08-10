package org.celllife.idart.domain.systemfacility

import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.system.System

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 20h59
 */
class SystemFacility {

    Long pk

    System fromSystem

    Facility toFacility

    SystemFacilityRelationship relationship

}
