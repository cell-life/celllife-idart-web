package org.celllife.idart.domain.partyfacility

import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.party.Party

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 11h22
 */
class PartyFacility implements Persistable<Long> {

    /**
     * Persistence Key
     */
    Long pk

    /**
     * Type
     */
    PartyFacilityType type

    /**
     * Involving
     */
    Party party

    /**
     * Involving
     */
    Facility facility

    Date fromDate

    Date thruDate

}
