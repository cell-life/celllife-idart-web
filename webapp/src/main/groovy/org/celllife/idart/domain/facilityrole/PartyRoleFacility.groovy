package org.celllife.idart.domain.facilityrole

import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.facility.Facility

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 11h22
 */
abstract class PartyRoleFacility implements Persistable {

    /**
     * Persistence Key
     */
    Long pk

    /**
     * Involving
     */
    Facility facility

    Date fromDate

    Date thruDate

}
