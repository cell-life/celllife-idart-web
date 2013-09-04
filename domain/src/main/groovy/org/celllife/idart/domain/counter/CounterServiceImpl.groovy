package org.celllife.idart.domain.counter

import javax.inject.Inject
import javax.inject.Named

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 16h03
 */
@Named class CounterServiceImpl implements CounterService {

    @Inject CounterRepository counterRepository

    def Integer getNextValue(String counterName) {
        nextValue(counterName)
    }

    Integer nextValue(String counterName) {

        Counter counter = counterRepository.findOneByName(counterName)

        if (counter == null) {
            counter = new Counter(name: counterName)
        }

        Integer nextValue = counter.nextValue()

        counterRepository.save(counter)

        return nextValue
    }
}
