package org.celllife.idart.infrastructure.counter.authority

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.authority.AuthoritySequence
import org.celllife.idart.common.AuthorityId
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CounterAuthoritySequence implements AuthoritySequence {

    @Inject CounterService counterService

    @Override
    AuthorityId nextValue() {
        def value = counterService.getNextValue(IdentifiableType.AUTHORITY.toString())
        return AuthorityId.valueOf(String.format("%08d", value))
    }
}
