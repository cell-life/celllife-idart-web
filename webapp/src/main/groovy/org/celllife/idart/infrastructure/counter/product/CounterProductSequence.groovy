package org.celllife.idart.infrastructure.counter.product

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.product.ProductSequence
import org.celllife.idart.common.ProductId
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CounterProductSequence implements ProductSequence {

    @Inject CounterService counterService

    @Override
    ProductId nextValue() {
        def value = counterService.getNextValue(IdentifiableType.PRODUCT.toString())
        return ProductId.valueOf(String.format("%08d", value))
    }
}
