package org.celllife.idart.domain.product

import org.celllife.idart.common.ProductId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface ProductRepository {

    boolean exists(ProductId productId)

    Product save(Product product)

    Product findOne(ProductId productId)

}
