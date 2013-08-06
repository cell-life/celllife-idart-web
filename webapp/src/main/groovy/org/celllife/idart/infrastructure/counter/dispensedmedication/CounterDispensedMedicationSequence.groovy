package org.celllife.idart.infrastructure.counter.dispensedmedication

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.dispensedmedication.DispensedMedicationSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CounterDispensedMedicationSequence implements DispensedMedicationSequence {

    static final String CODE_COUNTER_NAME = "DispensedMedicationIdentifier"

    @Autowired CounterService counterService

    @Override
    Long nextValue() {
        counterService.getNextValue(CODE_COUNTER_NAME)
    }
}
