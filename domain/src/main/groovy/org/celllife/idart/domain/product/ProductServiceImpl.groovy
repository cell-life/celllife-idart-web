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
    
    @Inject ProductSequence productSequence
    
    @Override
    Boolean exists(ProductId productId) {
        productRepository.exists(productId)
    }
    
    @Override
    Product save(Product product) {

        def existingProduct = null

        if (product.id != null) {
            existingProduct = productRepository.findOne(product.id)
        } else {
            product.id = productSequence.nextValue()
        }

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
