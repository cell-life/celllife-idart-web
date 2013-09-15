package org.celllife.idart.security.product

import org.celllife.idart.application.product.dto.ProductDto
import org.celllife.idart.common.ProductId
import org.celllife.idart.domain.identifiable.Identifier
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

    ProductId save(Principal principal, productDto) {
        productApplicationService.save(productDto)
    }

    ProductDto findByProductId(Principal principal, ProductId productId) {
        productApplicationService.findByProductId(productId)
    }

    ProductDto findByIdentifier(Principal principal, Identifier identifier) {
        productApplicationService.findByIdentifier(identifier)
    }

}
