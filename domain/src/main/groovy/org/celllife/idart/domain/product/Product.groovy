package org.celllife.idart.domain.product

import groovy.transform.ToString

import org.celllife.idart.common.ProductId

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h13
 */
@ToString
abstract class Product implements Serializable {

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
