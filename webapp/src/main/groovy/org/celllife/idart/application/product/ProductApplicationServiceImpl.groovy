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

import org.springframework.transaction.annotation.Transactional

/**
 */
@Named class ProductApplicationServiceImpl implements ProductApplicationService {

    @Inject ProductService productService   

    @Inject ProductDtoAssembler productDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    @Transactional(readOnly = true)
    Boolean exists(ProductId productId) {
        productService.exists(productId)
    }

    @Override
    @Transactional
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
    @Transactional(readOnly = true)
    ProductDto findByProductId(ProductId productId) {
        def identifier = newIdentifier(productId.value)
        findByIdentifier(identifier)
    }

    @Override
    @Transactional(readOnly = true)
    ProductDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(PRODUCT, [identifier] as Set)
        if (identifiable == null) {
            throw new ProductNotFoundException("Could not find Product with id [${identifier}]")
        }

        def productId = productId(identifiable.getIdentifierValue(IDART_WEB.id))

        def product = productService.findByProductId(productId)

        def productDto = productDtoAssembler.toProductDto(product)
        productDto.identifiers = identifiable.identifiers

        productDto
    }

    @Override
    @Transactional(readOnly = true)
    ProductId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.findByIdentifiers(PRODUCT, identifiers)
        if (identifiable == null) {
            throw new ProductNotFoundException("Could not find Product with id [${identifiers}]")
        }

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        productId(idartIdentifierValue)
    }
}