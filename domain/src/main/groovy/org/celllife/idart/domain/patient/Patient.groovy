package org.celllife.idart.domain.patient

import static org.celllife.idart.common.Period.newPeriod
import groovy.transform.ToString

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
@ToString
class Patient implements Serializable {

    /**
     * Identified by
     */
    PatientId id

    /**
     * Valid during
     */
    Period valid = newPeriod()

    /**
     * Acted by
     */
    PersonId person

    def merge(Patient that) {

        if (that == null) {
            return
        }

        if (this.valid == null) {
            this.valid = that.valid
        }

        if (that.person != null) {
            this.person = that.person
        }
    }

}
