package org.celllife.idart.infrastructure.counter.prescribedmedication

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CounterPrescribedMedicationSequence implements PrescribedMedicationSequence {

    static final String CODE_COUNTER_NAME = "PrescribedMedicationIdentifier"

    @Autowired CounterService counterService

    @Override
    Long nextValue() {
        counterService.getNextValue(CODE_COUNTER_NAME)
    }
}
