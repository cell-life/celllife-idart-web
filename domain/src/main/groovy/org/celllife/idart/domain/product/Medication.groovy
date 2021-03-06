package org.celllife.idart.domain.product

import groovy.transform.ToString

import org.celllife.idart.common.PartId

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 19h42
 */
@ToString
class Medication extends Product {

    /**
     * Offered using
     */
    PartId drug

    def merge(Medication that) {
        super.merge(that)
        this.drug = that.drug
    }
}
