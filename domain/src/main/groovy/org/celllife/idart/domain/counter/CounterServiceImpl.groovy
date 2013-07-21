package org.celllife.idart.domain.counter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 16h03
 */
@Service class CounterServiceImpl implements CounterService {

    @Autowired CounterRepository counterRepository

    def Integer getNextValue(String counterName) {
        synchronized (counterName.intern()) {
            nextValue(counterName)
        }
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
