package org.celllife.idart.infrastructure.counter.prescription

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.prescription.PrescriptionSequence
import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CounterPrescriptionSequence implements PrescriptionSequence {

    @Inject CounterService counterService

    @Override
    PrescriptionId nextValue() {
        def value = counterService.getNextValue(IdentifiableType.PRESCRIPTION.toString())
        return PrescriptionId.valueOf(String.format("%08d", value))
    }
}
