package org.celllife.idart.domain.medication

import org.celllife.idart.domain.drug.Drug
import org.celllife.idart.domain.product.Product

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
    Drug drug

    def merge(Medication that) {
        super.merge(that)
        this.drug = that.drug
    }
}
