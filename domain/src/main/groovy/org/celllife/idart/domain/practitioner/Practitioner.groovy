package org.celllife.idart.domain.practitioner

import org.celllife.idart.domain.partyrole.PersonRole

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 09h14
 */
class Practitioner extends PersonRole {

    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/practitioners"

    def merge(Practitioner that) {
        super.merge(that)
    }
}
