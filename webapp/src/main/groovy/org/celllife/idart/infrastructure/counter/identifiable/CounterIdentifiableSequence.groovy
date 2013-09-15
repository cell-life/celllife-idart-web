package org.celllife.idart.infrastructure.counter.identifiable

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.identifiable.IdentifiableSeqeuence
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.inject.Inject
import javax.inject.Named

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 19h50
 */
@Named class CounterIdentifiableSequence implements IdentifiableSeqeuence {

    @Inject CounterService counterService

    @Override
    Long nextValue(IdentifiableType type) {
        def value = counterService.getNextValue(type.toString())
        return value
    }
}
