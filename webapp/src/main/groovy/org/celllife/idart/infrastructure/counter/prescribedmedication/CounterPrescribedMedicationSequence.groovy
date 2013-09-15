package org.celllife.idart.infrastructure.counter.prescribedmedication

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationSequence
import org.celllife.idart.common.PrescribedMedicationId
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CounterPrescribedMedicationSequence implements PrescribedMedicationSequence {

    @Inject CounterService counterService

    @Override
    PrescribedMedicationId nextValue() {
        def value = counterService.getNextValue(IdentifiableType.PRESCRIBED_MEDICATION.toString())
        return PrescribedMedicationId.valueOf(String.format("%08d", value))
    }
}
