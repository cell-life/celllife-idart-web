package org.celllife.idart.domain.product

import org.celllife.idart.common.ProductId

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h13
 */
abstract class Product {

    /**
     * Identified by
     */
    ProductId id

    /**
     * Name
     */
    String name

    def merge(Product that) {
        this.name = that.name
    }

}
