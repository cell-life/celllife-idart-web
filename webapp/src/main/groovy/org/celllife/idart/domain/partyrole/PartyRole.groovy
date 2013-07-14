package org.celllife.idart.domain.partyrole

import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.facilityrole.PartyRoleFacility

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 09h13
 */
@Mixin([Identifiable])
abstract class PartyRole implements Persistable {

    /**
     * Persistence Key
     */
    Long pk

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    /**
     * From date
     */
    Date fromDate = new Date()

    /**
     * Thru date
     */
    Date thruDate

    /**
     * involved in
     */
    Set<PartyRoleFacility> facilities

}
