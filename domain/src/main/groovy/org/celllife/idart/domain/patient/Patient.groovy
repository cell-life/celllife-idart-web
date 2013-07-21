package org.celllife.idart.domain.patient

import org.celllife.idart.domain.partyrole.PersonRole

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 09h14
 */
class Patient extends PersonRole {

    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/patients"

    def merge(Patient that) {
        super.merge(that)
    }
}
