package org.celllife.idart.infrastructure.counter.medication

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.medication.MedicationSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CounterMedicationSequence implements MedicationSequence {

    static final String CODE_COUNTER_NAME = "MedicationIdentifier"

    @Autowired CounterService counterService

    @Override
    Long nextValue() {
        counterService.getNextValue(CODE_COUNTER_NAME)
    }
}
