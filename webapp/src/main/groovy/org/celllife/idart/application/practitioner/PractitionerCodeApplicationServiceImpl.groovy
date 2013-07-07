package org.celllife.idart.application.practitioner

import org.celllife.idart.domain.counter.CounterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service class PractitionerCodeApplicationServiceImpl implements PractitionerCodeApplicationService {

    static final String PRACTITIONER_CODE_COUNTER_NAME = "PractitionerCode"

    static final String PRACTITIONER_CODE_FORMAT = "%08d"

    @Autowired CounterService counterService

    String nextPractitionerCode() {
        String.format(PRACTITIONER_CODE_FORMAT, counterService.getNextValue(PRACTITIONER_CODE_COUNTER_NAME))
    }
}