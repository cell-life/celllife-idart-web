package org.celllife.idart.application.code;

import org.celllife.idart.domain.counter.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 15h59
 */
@Service("doctorCodeApplicationService")
public class DoctorCodeApplicationServiceImpl implements DoctorCodeApplicationService {

    private static final String PATIENT_CODE_COUNTER_NAME = "DoctorCode";

    private static final String PATIENT_CODE_FORMAT = "%08d";

    @Autowired
    private CounterService counterService;

    @Override
    public String nextDoctorCode() {

        Integer nextValue = counterService.getNextValue(PATIENT_CODE_COUNTER_NAME);

        return String.format(PATIENT_CODE_FORMAT, nextValue);
    }
}
