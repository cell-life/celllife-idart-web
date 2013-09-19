package org.celllife.idart.infrastructure.counter.identifiable

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.identifiable.IdentifiableSeqeuence
import org.celllife.idart.common.IdentifiableType
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.Identifiers

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.common.Systems.IDART_WEB

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 19h50
 */
@Named class CounterIdentifiableSequence implements IdentifiableSeqeuence {

    @Inject CounterService counterService

    @Override
    Identifier nextValue(IdentifiableType type) {
        def value = counterService.getNextValue(type.toString())
        return Identifiers.newIdentifier(String.format("%08d", value))
    }
}
