package org.celllife.idart.domain.counter

import org.celllife.idart.domain.common.Persistable

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 15h59
 */
class Counter implements Persistable<Long> {

    /**
     * Persistence Key
     */
    Long pk

    String name

    Integer value = 0

    def Integer nextValue() {
        value++
    }
}
