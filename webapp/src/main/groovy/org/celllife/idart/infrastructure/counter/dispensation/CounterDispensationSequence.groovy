package org.celllife.idart.infrastructure.counter.dispensation

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.dispensation.DispensationSequence
import org.celllife.idart.common.DispensationId
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CounterDispensationSequence implements DispensationSequence {

    @Inject CounterService counterService

    @Override
    DispensationId nextValue() {
        def value = counterService.getNextValue(IdentifiableType.DISPENSATION.toString())
        return DispensationId.valueOf(String.format("%08d", value))
    }
}
