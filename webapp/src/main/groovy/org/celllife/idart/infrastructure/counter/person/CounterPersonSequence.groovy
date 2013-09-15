package org.celllife.idart.infrastructure.counter.person

import org.celllife.idart.domain.counter.CounterService
import org.celllife.idart.domain.person.PersonSequence
import org.celllife.idart.common.PersonId
import org.celllife.idart.domain.identifiable.IdentifiableType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CounterPersonSequence implements PersonSequence {

    @Inject CounterService counterService

    @Override
    PersonId nextValue() {
        def value = counterService.getNextValue(IdentifiableType.PERSON.toString())
        return PersonId.valueOf(String.format("%08d", value))
    }
}
