package org.celllife.idart.application.product

import org.celllife.idart.application.product.dto.ProductDto
import org.celllife.idart.common.ProductId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.product.ProductNotFoundException
import org.celllife.idart.domain.product.ProductService

import static org.celllife.idart.application.product.dto.ProductDtoAssembler.toProduct
import static org.celllife.idart.application.product.dto.ProductDtoAssembler.toProductDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.ProductId.productId
import static org.celllife.idart.domain.identifiable.IdentifiableType.PRODUCT
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class ProductApplicationServiceImpl implements ProductApplicationService {

    @Inject ProductService productService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(ProductId productId) {
        productService.exists(productId)
    }

    ProductId save(ProductDto productDto) {

        def product = toProduct(productDto)

        def identifiable = identifiableService.findByIdentifiers(PRODUCT, productDto.identifiers)
        if (identifiable == null) {

            product = productService.save(product)

            identifiable = new Identifiable(type: PRODUCT, identifiers: productDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, product.id.value))
            identifiableService.save(identifiable)

        } else {

            product.id = productId(identifiable.getIdentifier(IDART).value)
            productService.save(product)

        }

        product.id
    }

    @Override
    ProductDto findByProductId(ProductId productId) {
        def identifier = newIdentifier(IDART, productId.value)
        findByIdentifier(identifier)
    }

    @Override
    ProductDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(PRODUCT, [identifier] as Set)

        if (identifiable == null) {
            throw new ProductNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def productId = productId(identifiable.getIdentifier(IDART).value)

        def product = productService.findByProductId(productId)

        def productDto = toProductDto(product)
        productDto.identifiers = identifiable.identifiers

        productDto
    }
}
