package org.celllife.idart.application.systemfacility.dto

import org.celllife.idart.common.Identifier
import org.celllife.idart.relationship.systemfacility.SystemFacility

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-17
 * Time: 19h23
 */
class SystemFacilityDto implements Serializable {

    Set<Identifier> system

    Set<Identifier> facility

    SystemFacility.Relationship relationship

}
