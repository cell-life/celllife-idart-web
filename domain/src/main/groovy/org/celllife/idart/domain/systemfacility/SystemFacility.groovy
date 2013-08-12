package org.celllife.idart.domain.systemfacility

import org.celllife.idart.common.FacilityIdentifier
import org.celllife.idart.common.SystemIdentifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 20h59
 */
class SystemFacility {

    Long pk

    SystemIdentifier fromSystem

    FacilityIdentifier toFacility

    SystemFacilityRelationship relationship

}
