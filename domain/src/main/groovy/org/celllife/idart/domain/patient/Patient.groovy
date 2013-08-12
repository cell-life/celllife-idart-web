package org.celllife.idart.domain.patient

import org.celllife.idart.common.PartyIdentifier
import org.celllife.idart.common.PatientIdentifier
import org.celllife.idart.common.Period

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
    PatientIdentifier identifier

    /**
     * Valid during
     */
    Period valid

    /**
     * Acted by
     */
    PartyIdentifier person

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
