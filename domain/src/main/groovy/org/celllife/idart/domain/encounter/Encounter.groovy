package org.celllife.idart.domain.encounter

import org.celllife.idart.common.EncounterId

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-22
 * Time: 01h03
 */
class Encounter {

    /**
     * Identified by
     */
    EncounterId id

    def merge(Encounter that) {

        if (that == null) {
            return
        }
    }
}
