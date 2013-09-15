package org.celllife.idart.application.product.dto

import org.celllife.idart.domain.product.Product

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-15
 * Time: 13h26
 */
class UnsupportedProductType extends RuntimeException {

    UnsupportedProductType(Class<Product> productClass) {
        super(productClass.toString())
    }
}
