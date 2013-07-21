package org.celllife.idart.domain.party

import org.celllife.idart.domain.partyclassification.PartyClassification

import javax.validation.constraints.NotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 10h23
 */
class PartyClassificationApplication {

    /**
     * described by
     */
    PartyClassification classification

    @NotNull
    Date fromDate

    Date thruDate

}
