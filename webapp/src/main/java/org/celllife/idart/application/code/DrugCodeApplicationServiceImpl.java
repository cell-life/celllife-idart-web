package org.celllife.idart.application.code;

import org.celllife.idart.domain.counter.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 16h07
 */
@Service("drugCodeApplicationService")
public class DrugCodeApplicationServiceImpl implements DrugCodeApplicationService {

    private static final String DRUG_CODE_COUNTER_NAME = "DrugCode";

    private static final String DRUG_CODE_FORMAT = "%08d";

    @Autowired
    private CounterService counterService;

    @Override
    public String nextDrugCode() {

        Integer nextValue = counterService.getNextValue(DRUG_CODE_COUNTER_NAME);

        return String.format(DRUG_CODE_FORMAT, nextValue);
    }
}
