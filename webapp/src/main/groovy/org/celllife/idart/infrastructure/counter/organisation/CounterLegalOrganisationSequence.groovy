package org.celllife.idart.infrastructure.counter.organisation

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.organisation.LegalOrganisationSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CounterLegalOrganisationSequence implements LegalOrganisationSequence {

    static final String CODE_COUNTER_NAME = "LegalOrganisationIdentifier"

    @Autowired CounterService counterService

    @Override
    Long nextValue() {
        counterService.getNextValue(CODE_COUNTER_NAME)
    }
}
