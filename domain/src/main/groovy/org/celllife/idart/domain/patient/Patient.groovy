package org.celllife.idart.domain.patient

import org.celllife.idart.common.PatientId
import org.celllife.idart.common.Period
import org.celllife.idart.common.PersonId

/**
 * Party Role -> Person Role -> Patient
 *
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 09h14
 */
class Patient {

    /**
     * Namespace
     */
    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/patients"

    /**
     * Identified by
     */
    PatientId id

    /**
     * Valid during
     */
    Period valid

    /**
     * Acted by
     */
    PersonId person

    def merge(Patient that) {

        if (that == null) {
            return
        }

        this.valid = that.valid

        if (that.person != null) {
            this.person = that.person
        }
    }
}
