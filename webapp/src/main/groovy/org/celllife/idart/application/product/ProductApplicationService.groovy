package org.celllife.idart.application.product

import org.celllife.idart.application.product.dto.ProductDto
import org.celllife.idart.common.ProductId
import org.celllife.idart.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface ProductApplicationService {

    Boolean exists(ProductId productId)

    ProductId save(ProductDto productDto)

    ProductDto findByProductId(ProductId productId)

    ProductDto findByIdentifier(Identifier identifier)

    ProductId findByIdentifiers(Set<Identifier> identifiers)

}
