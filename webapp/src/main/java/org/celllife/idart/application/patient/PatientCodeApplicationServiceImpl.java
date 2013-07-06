package org.celllife.idart.application.patient;

import org.celllife.idart.domain.counter.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 16h07
 */
@Service("patientCodeApplicationService")
public class PatientCodeApplicationServiceImpl implements PatientCodeApplicationService {

    private static final String PATIENT_CODE_COUNTER_NAME = "PatientCode";

    private static final String PATIENT_CODE_FORMAT = "%08d";

    @Autowired
    private CounterService counterService;

    @Override
    public String nextPatientIdentifierValue() {

        Integer nextValue = counterService.getNextValue(PATIENT_CODE_COUNTER_NAME);

        return String.format(PATIENT_CODE_FORMAT, nextValue);
    }
}
