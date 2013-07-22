package org.celllife.idart.infrastructure.counter.product

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.product.GoodSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CounterGoodSequence implements GoodSequence {

    static final String CODE_COUNTER_NAME = "GoodCode"

    @Autowired CounterService counterService

    @Override
    Long nextValue() {
        counterService.getNextValue(CODE_COUNTER_NAME)
    }
}
