package org.celllife.idart.domain.practitioner

import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.person.Person

import javax.validation.constraints.NotNull

/**
 * Party Role -> Person Role -> Practitioner
 *
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 09h14
 */
@Mixin([Identifiable])
class Practitioner {

    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/practitioners"

    /**
     * Persistence Key
     */
    String pk

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    /**
     * From date
     */
    Date fromDate

    /**
     * Thru date
     */
    Date thruDate

    /**
     * Acted by
     */
    @NotNull
    Person person

    def merge(Practitioner that) {

        if (that == null) {
            return
        }

        that.identifierSystems.each { system -> this.addIdentifier(system, that.getIdentifierValue(system)) }
        this.fromDate = that.fromDate
        this.thruDate = that.thruDate
        this.person = that.person
    }
}
