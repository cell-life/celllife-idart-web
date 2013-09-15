package org.celllife.idart.infrastructure.counter.encounter

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.encounter.EncounterSequence
import org.celllife.idart.common.EncounterId
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CounterEncounterSequence implements EncounterSequence {

    @Inject CounterService counterService

    @Override
    EncounterId nextValue() {
        def value = counterService.getNextValue(IdentifiableType.ENCOUNTER.toString())
        return EncounterId.valueOf(String.format("%08d", value))
    }
}
