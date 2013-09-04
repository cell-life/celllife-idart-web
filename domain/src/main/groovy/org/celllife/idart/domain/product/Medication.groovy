package org.celllife.idart.domain.product

import org.celllife.idart.common.PartId

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 19h42
 */
class Medication extends Product {

    static String IDART_SYSTEM = "http://www.cell-life.org/idart/medications"

    /**
     * Offered using
     */
    PartId drug

    def merge(Medication that) {
        super.merge(that)
        this.drug = that.drug
    }
}
