package org.celllife.idart.application.doctor;

import org.celllife.idart.application.doctor.DoctorCodeApplicationService;
import org.celllife.idart.domain.counter.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorCodeApplicationServiceImpl implements DoctorCodeApplicationService {

    private static final String DOCTOR_CODE_COUNTER_NAME = "DoctorCode";

    private static final String DOCTOR_CODE_FORMAT = "%08d";

    @Autowired
    private CounterService counterService;

    public String nextDoctorCode() {

        Integer nextValue = counterService.getNextValue(DOCTOR_CODE_COUNTER_NAME);

        return String.format(DOCTOR_CODE_FORMAT, nextValue);
    }
}