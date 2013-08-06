package org.celllife.idart.infrastructure.counter.practitioner

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.practitioner.PractitionerSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CounterPractitionerSequence implements PractitionerSequence {

    static final String CODE_COUNTER_NAME = "PractitionerIdentifier"

    @Autowired CounterService counterService

    @Override
    Long nextValue() {
        counterService.getNextValue(CODE_COUNTER_NAME)
    }
}
