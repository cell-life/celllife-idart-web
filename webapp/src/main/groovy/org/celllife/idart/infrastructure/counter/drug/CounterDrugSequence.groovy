package org.celllife.idart.infrastructure.counter.drug

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.drug.DrugSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CounterDrugSequence implements DrugSequence {

    static final String CODE_COUNTER_NAME = "DrugIdentifier"

    @Autowired CounterService counterService

    @Override
    Long nextValue() {
        counterService.getNextValue(CODE_COUNTER_NAME)
    }
}
