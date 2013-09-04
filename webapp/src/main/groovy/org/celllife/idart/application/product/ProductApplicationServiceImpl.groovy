package org.celllife.idart.application.product

import org.celllife.idart.common.ProductId
import org.celllife.idart.domain.product.Product
import org.celllife.idart.domain.product.ProductService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class ProductApplicationServiceImpl implements ProductApplicationService {

    @Inject ProductService productService

    Product save(Product product) {
        productService.save(product)
    }

    Product findByProductId(ProductId productId) {
        productService.findByProductId(productId)
    }

}
