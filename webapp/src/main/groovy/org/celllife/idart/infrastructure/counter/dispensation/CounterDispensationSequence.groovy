package org.celllife.idart.infrastructure.counter.dispensation

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.dispensation.DispensationSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CounterDispensationSequence implements DispensationSequence {

    static final String CODE_COUNTER_NAME = "DispensationIdentifier"

    @Autowired CounterService counterService

    @Override
    Long nextValue() {
        counterService.getNextValue(CODE_COUNTER_NAME)
    }
}
