package org.celllife.idart.domain.encounter

import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.common.Persistable

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-22
 * Time: 01h03
 */
@Mixin(Identifiable)
class Encounter implements Persistable<Long> {

    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/encounters"

    /**
     * Persistence Key
     */
    Long pk

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    def merge(Encounter that) {

        if (that == null) {
            return
        }

        that.identifierSystems.each { system -> this.addIdentifier(system, that.getIdentifierValue(system)) }
    }
}
