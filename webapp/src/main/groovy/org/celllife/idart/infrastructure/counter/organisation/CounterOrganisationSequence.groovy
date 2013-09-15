package org.celllife.idart.infrastructure.counter.organisation

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.organisation.OrganisationSequence
import org.celllife.idart.common.OrganisationId
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CounterOrganisationSequence implements OrganisationSequence {

    @Inject CounterService counterService

    @Override
    OrganisationId nextValue() {
        def value = counterService.getNextValue(IdentifiableType.ORGANISATION.toString())
        return OrganisationId.valueOf(String.format("%08d", value))
    }
}
