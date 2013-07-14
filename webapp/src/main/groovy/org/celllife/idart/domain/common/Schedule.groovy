package org.celllife.idart.domain.common

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 *
 * A schedule that specifies an event that may occur multiple times. Schedules are not used for recording when things
 * did happen, but when they are expected or requested to occur. A schedule can be either a list of events - periods on
 * which the event occurs, or a single event with repeating criteria, or just repeating criteria with no actual event.
 *
 * Constraints
 * - There can only be a repeat element if there is none or one event (xpath: not(exists(f:repeat)) or count(f:event) < 2)
 * - On Schedule.repeat: At most, only one of count and end can be present (xpath on f:Schedule/f:repeat: not(exists(f:count) and exists(f:end)))
 * - On Schedule.repeat: Either frequency or when must be present, but not both (xpath on f:Schedule/f:repeat: exists(f:frequency) != exists(f:when))
 * - On Schedule.repeat.duration: duration must be a positive value (xpath on f:Schedule/f:repeat/f:duration: @value > 0 or not(@value))
 *
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 21h33
 */
@ToString
@EqualsAndHashCode
class Schedule {

    /**
     * When the event occurs
     */
    Set<Period> events

    /**
     *  Only if there is none or one event
     */
    Repeat repeat

}
