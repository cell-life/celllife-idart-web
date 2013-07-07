package org.celllife.idart.application.patient

import org.celllife.idart.domain.counter.CounterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 16h07
 */
@Service class PatientCodeApplicationServiceImpl implements PatientCodeApplicationService {

    static final String PATIENT_CODE_COUNTER_NAME = "PatientCode"

    static final String PATIENT_CODE_FORMAT = "%08d"

    @Autowired CounterService counterService

    @Override
    String nextPatientIdentifierValue() {
        String.format(PATIENT_CODE_FORMAT, counterService.getNextValue(PATIENT_CODE_COUNTER_NAME))
    }
}
