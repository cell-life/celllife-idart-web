package org.celllife.idart.domain.product

import org.celllife.idart.common.ProductId

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.product.ProductEvent.EventType.SAVED
import static org.celllife.idart.domain.product.ProductEvent.newProductEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class ProductServiceImpl implements ProductService {

    @Inject ProductRepository productRepository

    @Inject ProductValidator productValidator

    @Inject ProductEventPublisher productEventPublisher

    @Override
    Product save(Product product) {

        productValidator.validate(product)

        productEventPublisher.publish(newProductEvent(product, SAVED))

        productRepository.save(product)
    }

    @Override
    Product findByProductId(ProductId productId) {

        def product = productRepository.findOne(productId)

        if (product == null) {
            throw new ProductNotFoundException("Could not find Product with Product Id [${ productId}]")
        }

        product
    }
}
