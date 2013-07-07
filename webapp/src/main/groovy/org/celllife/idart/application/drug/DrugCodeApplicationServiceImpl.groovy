package org.celllife.idart.application.drug

import org.celllife.idart.domain.counter.CounterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static java.lang.String.format

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 16h07
 */
@Service class DrugCodeApplicationServiceImpl implements DrugCodeApplicationService {

    static final String DRUG_CODE_COUNTER_NAME = "DrugCode"

    static final String DRUG_CODE_FORMAT = "%08d"

    @Autowired CounterService counterService

    @Override
    String nextDrugCode() {
        format(DRUG_CODE_FORMAT, counterService.getNextValue(DRUG_CODE_COUNTER_NAME))
    }
}
