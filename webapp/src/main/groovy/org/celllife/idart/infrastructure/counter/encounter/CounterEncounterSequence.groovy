package org.celllife.idart.infrastructure.counter.encounter

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.encounter.EncounterSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CounterEncounterSequence implements EncounterSequence {

    static final String CODE_COUNTER_NAME = "EncounterIdentifier"

    @Autowired CounterService counterService

    @Override
    Long nextValue() {
        counterService.getNextValue(CODE_COUNTER_NAME)
    }
}
