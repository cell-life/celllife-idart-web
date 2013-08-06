package org.celllife.idart.infrastructure.counter.clinic

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.clinic.ClinicSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CounterClinicSequence implements ClinicSequence {

    static final String CODE_COUNTER_NAME = "ClinicIdentifier"

    @Autowired CounterService counterService

    @Override
    Long nextValue() {
        counterService.getNextValue(CODE_COUNTER_NAME)
    }
}
