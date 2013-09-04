package org.celllife.idart.application.product

import org.celllife.idart.common.ProductId
import org.celllife.idart.domain.product.Product

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface ProductApplicationService {

    Product save(Product product)

    Product findByProductId(ProductId productId)

}
