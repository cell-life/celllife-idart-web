package org.celllife.idart.domain.product

import org.celllife.idart.common.ProductId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface ProductService {

    Boolean exists(ProductId productId)

    Product save(Product product)

    Product findByProductId(ProductId productId)

}
