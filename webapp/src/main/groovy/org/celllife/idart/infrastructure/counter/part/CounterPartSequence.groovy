package org.celllife.idart.infrastructure.counter.part

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.part.PartSequence
import org.celllife.idart.common.PartId
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CounterPartSequence implements PartSequence {

    @Inject CounterService counterService

    @Override
    PartId nextValue() {
        def value = counterService.getNextValue(IdentifiableType.PART.toString())
        return PartId.valueOf(String.format("%08d", value))
    }
}
