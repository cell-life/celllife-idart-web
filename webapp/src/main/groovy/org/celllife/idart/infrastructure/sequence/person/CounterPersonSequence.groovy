package org.celllife.idart.infrastructure.sequence.person

import org.celllife.idart.domain.person.PersonSequence
import org.celllife.idart.domain.counter.CounterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 23h11
 */
@Service class CounterPersonSequence implements PersonSequence {

    static final String PERSON_CODE_COUNTER_NAME = "PersonCode"

    @Autowired CounterService counterService

    @Override
    Long nextValue() {
        counterService.getNextValue(PERSON_CODE_COUNTER_NAME)
    }
}
