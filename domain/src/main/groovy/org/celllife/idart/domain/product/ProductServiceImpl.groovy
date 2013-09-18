package org.celllife.idart.domain.product

import org.celllife.idart.common.ProductId

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.product.ProductEvent.EventType.SAVED
import static org.celllife.idart.domain.product.ProductEvent.newProductEvent

/**
 */
@Named class ProductServiceImpl implements ProductService {

    @Inject ProductRepository productRepository

    @Inject ProductValidator productValidator

    @Inject ProductEventPublisher productEventPublisher

    @Override
    Boolean exists(ProductId productId) {
        productRepository.exists(productId)
    }

    @Override
    Product save(Product product) {

        def existingProduct = productRepository.findOne(product.id)

        if (existingProduct == null) {
            existingProduct = product
        } else {
            existingProduct.merge(product)
        }

        productValidator.validate(existingProduct)

        productEventPublisher.publish(newProductEvent(existingProduct, SAVED))

        productRepository.save(existingProduct)
    }

    @Override
    Product findByProductId(ProductId productId) {

        def product = productRepository.findOne(productId)

        if (product == null) {
            throw new ProductNotFoundException("Could not find Product with id [${ productId}]")
        }

        product
    }
}
