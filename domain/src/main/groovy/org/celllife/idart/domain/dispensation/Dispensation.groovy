package org.celllife.idart.domain.dispensation

import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.common.Persistable

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-22
 * Time: 01h13
 */
@Mixin([Identifiable])
class Dispensation implements Persistable<Long> {

    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/dispensations"

    /**
     * Persistence Key
     */
    Long pk

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    def merge(Dispensation that) {

        if (that == null) {
            return
        }

        this.mergeIdentifiers(that)
    }
}
