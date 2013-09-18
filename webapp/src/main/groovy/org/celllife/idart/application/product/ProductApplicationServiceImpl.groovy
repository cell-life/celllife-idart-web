package org.celllife.idart.application.product

import org.celllife.idart.application.product.dto.ProductDto
import org.celllife.idart.application.product.dto.ProductDtoAssembler
import org.celllife.idart.common.ProductId
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.product.ProductNotFoundException
import org.celllife.idart.domain.product.ProductService

import static org.celllife.idart.common.ProductId.productId
import static org.celllife.idart.common.IdentifiableType.PRODUCT
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Systems.IDART_WEB

import javax.inject.Inject
import javax.inject.Named

/**
 */
@Named class ProductApplicationServiceImpl implements ProductApplicationService {

    @Inject ProductService productService   

    @Inject ProductDtoAssembler productDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(ProductId productId) {
        productService.exists(productId)
    }

    @Override
    ProductId save(ProductDto productDto) {

        def identifiable = identifiableService.resolveIdentifiable(PRODUCT, productDto.identifiers)
        productDto.identifiers = identifiable.identifiers

        def productId = productId(identifiable.getIdentifierValue(IDART_WEB.id))

        def product = productDtoAssembler.toProduct(productDto)
        product.id = productId

        productService.save(product)

        product.id
    }

    @Override
    ProductDto findByProductId(ProductId productId) {
        def identifier = newIdentifier(IDART_WEB.id, productId.value)
        findByIdentifier(identifier)
    }

    @Override
    ProductDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(PRODUCT, [identifier] as Set)

        if (identifiable == null) {
            throw new ProductNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def productId = productId(identifiable.getIdentifierValue(IDART_WEB.id))

        def product = productService.findByProductId(productId)

        def productDto = productDtoAssembler.toProductDto(product)
        productDto.identifiers = identifiable.identifiers

        productDto
    }

    @Override
    ProductId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(PRODUCT, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        productId(idartIdentifierValue)
    }
}
