package org.celllife.idart.domain.practitioner

import org.celllife.idart.common.Period
import org.celllife.idart.common.PersonId
import org.celllife.idart.common.PractitionerId
import org.celllife.idart.common.PractitionerType

import javax.validation.Valid
import javax.validation.constraints.NotNull

import static org.celllife.idart.common.Period.newPeriod

/**
 * Party Role -> Person Role -> Practitioner
 *
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 09h14
 */
class Practitioner {

    /**
     * Identified by
     */
    PractitionerId id

    /**
     * Of Type
     */
    PractitionerType type

    /**
     * Valid during
     */
    Period valid = newPeriod()

    /**
     * Acted by
     */
    PersonId person

    def merge(Practitioner that) {

        if (that == null) {
            return
        }

        if (that.type != null) {
            this.type = that.type
        }

        if (that.valid != null) {
            this.valid = that.valid
        }

        if (that.person != null) {
            this.person = that.person
        }
    }
}
