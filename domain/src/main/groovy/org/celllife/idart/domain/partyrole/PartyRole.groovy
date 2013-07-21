package org.celllife.idart.domain.partyrole

import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.common.Persistable

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 09h13
 */
@Mixin([Identifiable])
abstract class PartyRole implements Persistable<Long> {

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

    def merge(PartyRole that) {

        if (that == null) {
            return
        }

        this.mergeIdentifiers(that)
        this.fromDate = that.fromDate
        this.thruDate = that.thruDate
    }
}
