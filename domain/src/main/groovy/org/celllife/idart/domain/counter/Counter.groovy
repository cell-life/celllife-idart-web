package org.celllife.idart.domain.counter

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 15h59
 */
class Counter implements Serializable {

    /**
     * Persistence Key
     */
    Long pk

    String name

    Integer nextValue = 0

    def Integer nextValue() {
        nextValue++
    }
}
