package org.celllife.idart.infrastructure.counter.facility

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.facility.FacilitySequence
import org.celllife.idart.common.FacilityId
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CounterFacilitySequence implements FacilitySequence {

    @Inject CounterService counterService

    @Override
    FacilityId nextValue() {
        def value = counterService.getNextValue(IdentifiableType.FACILITY.toString())
        return FacilityId.valueOf(String.format("%08d", value))
    }
}
