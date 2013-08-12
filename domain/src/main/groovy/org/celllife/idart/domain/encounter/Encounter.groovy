package org.celllife.idart.domain.encounter

import org.celllife.idart.common.EncounterIdentifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-22
 * Time: 01h03
 */
class Encounter {

    /**
     * Namespace
     */
    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/encounters"

    /**
     * Identified by
     */
    EncounterIdentifier identifier

    def merge(Encounter that) {

        if (that == null) {
            return
        }
    }
}
