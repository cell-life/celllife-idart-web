package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * A schedule that specifies an event that may occur multiple times. Schedules are not used for recording when things
 * did happen, but when they are expected or requested to occur. A schedule can be either a list of events - periods on
 * which the event occurs, or a single event with repeating criteria, or just repeating criteria with no actual event.
 *
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 22h59
 */
@ToString
@EqualsAndHashCode
class Repeat {

    /**
     * Event occurs frequency times per duration
     */
    Integer frequency

    /**
     * Event occurs duration from common life event
     */
    LifeEventCode when

    /**
     * Repeating or event-related duration
     */
    Duration duration

    /**
     * Number of times to repeat
     */
    Integer count

    /**
     * When to stop repeats
     */
    Date end

}
