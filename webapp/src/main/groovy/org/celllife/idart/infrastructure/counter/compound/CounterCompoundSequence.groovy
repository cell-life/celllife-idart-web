package org.celllife.idart.infrastructure.counter.compound

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.compound.CompoundSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CounterCompoundSequence implements CompoundSequence {

    static final String CODE_COUNTER_NAME = "CompoundIdentifier"

    @Autowired CounterService counterService

    @Override
    Long nextValue() {
        counterService.getNextValue(CODE_COUNTER_NAME)
    }
}
