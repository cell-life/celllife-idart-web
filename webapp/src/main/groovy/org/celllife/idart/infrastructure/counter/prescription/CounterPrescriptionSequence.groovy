package org.celllife.idart.infrastructure.counter.prescription

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.prescription.PrescriptionSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CounterPrescriptionSequence implements PrescriptionSequence {

    static final String CODE_COUNTER_NAME = "PrescriptionIdentifier"

    @Autowired CounterService counterService

    @Override
    Long nextValue() {
        counterService.getNextValue(CODE_COUNTER_NAME)
    }
}
