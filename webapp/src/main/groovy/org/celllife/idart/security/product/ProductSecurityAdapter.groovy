package org.celllife.idart.security.product

import org.celllife.idart.common.ProductId
import org.celllife.idart.domain.product.Product
import org.celllife.idart.application.product.ProductApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class ProductSecurityAdapter {

    @Inject ProductApplicationService productApplicationService

    Product save(Principal principal, Product product) {
        productApplicationService.save(product)
    }

    Product findByProductId(Principal principal, ProductId productId) {
        productApplicationService.findByProductId(productId)
    }

}
