package org.celllife.idart.infrastructure.counter.defaultdosageinstruction

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionSequence
import org.celllife.idart.common.DefaultDosageInstructionId
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CounterDefaultDosageInstructionSequence implements DefaultDosageInstructionSequence {

    @Inject CounterService counterService

    @Override
    DefaultDosageInstructionId nextValue() {
        def value = counterService.getNextValue(IdentifiableType.DEFAULT_DOSAGE_INSTRUCTION.toString())
        return DefaultDosageInstructionId.valueOf(String.format("%08d", value))
    }
}
