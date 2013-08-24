package org.celllife.idart.domain.practitioner

import org.celllife.idart.common.Period
import org.celllife.idart.common.PersonId
import org.celllife.idart.common.PractitionerId

import javax.validation.constraints.NotNull

/**
 * Party Role -> Person Role -> Practitioner
 *
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 09h14
 */
class Practitioner {

    /**
     * Namespace
     */
    static NAMESPACE = "http://www.cell-life.org/idart/practitioners"

    /**
     * Identified by
     */
    PractitionerId id

    /**
     * Valid during
     */
    Period valid

    /**
     * Acted by
     */
    @NotNull
    PersonId person

    def merge(Practitioner that) {

        if (that == null) {
            return
        }

        this.valid = that.valid

        if (that.person != null) {
            this.person = that.person
        }
    }
}
