package org.celllife.idart.domain.product

import org.celllife.idart.domain.part.FinishedGood

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h14
 */
class Good extends Product {

    /**
     * Offered using
     */
    FinishedGood finishedGood

    def merge(Good that) {
        super.merge(that)
        this.finishedGood = that.finishedGood
    }
}
