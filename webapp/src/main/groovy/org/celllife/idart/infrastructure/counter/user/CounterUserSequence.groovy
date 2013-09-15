package org.celllife.idart.infrastructure.counter.user

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.user.UserSequence
import org.celllife.idart.common.UserId
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CounterUserSequence implements UserSequence {

    @Inject CounterService counterService

    @Override
    UserId nextValue() {
        def value = counterService.getNextValue(IdentifiableType.USER.toString())
        return UserId.valueOf(String.format("%08d", value))
    }
}
