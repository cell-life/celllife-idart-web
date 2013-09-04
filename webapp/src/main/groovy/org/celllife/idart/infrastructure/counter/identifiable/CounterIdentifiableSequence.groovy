package org.celllife.idart.infrastructure.counter.identifiable

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.identifiable.IdentifiableSeqeuence
import org.celllife.idart.domain.identifiable.IdentifiableType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 19h50
 */
@Component class CounterIdentifiableSequence implements IdentifiableSeqeuence {

    @Autowired CounterService counterService

    @Override
    Long nextValue(IdentifiableType type) {
        return counterService.getNextValue(type.toString())
    }
}
