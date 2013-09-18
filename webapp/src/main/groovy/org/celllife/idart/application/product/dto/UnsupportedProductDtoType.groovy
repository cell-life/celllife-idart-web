package org.celllife.idart.application.product.dto
/**
 * User: Kevin W. Sewell
 * Date: 2013-09-15
 * Time: 13h26
 */
class UnsupportedProductDtoType extends RuntimeException {

    UnsupportedProductDtoType(Class<ProductDto> productDtoClass) {
        super(productDtoClass.toString())
    }
}
