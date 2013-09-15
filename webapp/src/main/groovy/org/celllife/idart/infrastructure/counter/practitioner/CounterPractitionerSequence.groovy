package org.celllife.idart.infrastructure.counter.practitioner

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.practitioner.PractitionerSequence
import org.celllife.idart.common.PractitionerId
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CounterPractitionerSequence implements PractitionerSequence {

    @Inject CounterService counterService

    @Override
    PractitionerId nextValue() {
        def value = counterService.getNextValue(IdentifiableType.PRACTITIONER.toString())
        return PractitionerId.valueOf(String.format("%08d", value))
    }
}
