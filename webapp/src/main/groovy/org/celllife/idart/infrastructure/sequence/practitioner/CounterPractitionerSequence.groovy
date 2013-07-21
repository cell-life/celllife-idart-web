package org.celllife.idart.infrastructure.sequence.practitioner

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.practitioner.PractitionerSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service class CounterPractitionerSequence implements PractitionerSequence {

    static final String PRACTITIONER_CODE_COUNTER_NAME = "PractitionerCode"

    @Autowired CounterService counterService

    Long nextValue() {
        counterService.getNextValue(PRACTITIONER_CODE_COUNTER_NAME)
    }
}