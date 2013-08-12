package org.celllife.idart.domain.product

import org.celllife.idart.common.ProductIdentifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h13
 */
abstract class Product {

    /**
     * Identified by
     */
    ProductIdentifier identifier

    /**
     * Name
     */
    String name

    def merge(Product that) {
        this.name = that.name
    }

}
