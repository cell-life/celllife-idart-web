package org.celllife.idart.relationship.systemfacility

import groovy.transform.ToString

import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.Period
import org.celllife.idart.common.SystemId

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 20h59
 */
@ToString
class SystemFacility {

    enum Relationship {

        DEPLOYED_AT

    }

    Long pk

    SystemId system

    FacilityId facility

    Relationship relationship

    Period valid

}
