package org.celllife.idart.infrastructure.counter.patient

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.patient.PatientSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CounterPatientSequence implements PatientSequence {

    static final String CODE_COUNTER_NAME = "PatientIdentifier"

    @Autowired CounterService counterService

    @Override
    Long nextValue() {
        counterService.getNextValue(CODE_COUNTER_NAME)
    }
}
