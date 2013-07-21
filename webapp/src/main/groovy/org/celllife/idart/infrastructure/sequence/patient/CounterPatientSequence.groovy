package org.celllife.idart.infrastructure.sequence.patient

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.patient.PatientSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 16h07
 */
@Service class CounterPatientSequence implements PatientSequence {

    static final String PATIENT_CODE_COUNTER_NAME = "PatientCode"

    @Autowired CounterService counterService

    @Override
    Long nextValue() {
        counterService.getNextValue(PATIENT_CODE_COUNTER_NAME)
    }
}
