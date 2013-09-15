package org.celllife.idart.infrastructure.counter.patient

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.patient.PatientSequence
import org.celllife.idart.common.PatientId
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CounterPatientSequence implements PatientSequence {

    @Inject CounterService counterService

    @Override
    PatientId nextValue() {
        def value = counterService.getNextValue(IdentifiableType.PATIENT.toString())
        return PatientId.valueOf(String.format("%08d", value))
    }
}
