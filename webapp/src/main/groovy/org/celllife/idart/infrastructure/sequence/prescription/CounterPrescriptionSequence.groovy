package org.celllife.idart.infrastructure.sequence.prescription

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.prescription.PrescriptionSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service class CounterPrescriptionSequence implements PrescriptionSequence {

    static final String PRESCRIPTION_CODE_COUNTER_NAME = "PrescriptionCode"

    @Autowired CounterService counterService

    Long nextValue() {
        counterService.getNextValue(PRESCRIPTION_CODE_COUNTER_NAME)
    }
}