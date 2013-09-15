package org.celllife.idart.infrastructure.counter.system

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.system.SystemSequence
import org.celllife.idart.common.SystemId
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CounterSystemSequence implements SystemSequence {

    @Inject CounterService counterService

    @Override
    SystemId nextValue() {
        def value = counterService.getNextValue(IdentifiableType.SYSTEM.toString())
        return SystemId.valueOf(String.format("%08d", value))
    }
}
