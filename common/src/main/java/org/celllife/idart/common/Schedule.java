package org.celllife.idart.common;

import java.io.Serializable;
import java.util.Set;

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
public class Schedule implements Serializable {

    private static final long serialVersionUID = 2777875267080615075L;

    /**
     * When the event occurs
     */
    private Set<Period> events;

    /**
     *  Only if there is none or one event
     */
    private Repeat repeat;

    public Schedule() {
    }

    public Set<Period> getEvents() {
        return events;
    }

    public void setEvents(Set<Period> events) {
        this.events = events;
    }

    public Repeat getRepeat() {
        return repeat;
    }

    public void setRepeat(Repeat repeat) {
        this.repeat = repeat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        if (events != null ? !events.equals(schedule.events) : schedule.events != null) return false;
        if (repeat != null ? !repeat.equals(schedule.repeat) : schedule.repeat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = events != null ? events.hashCode() : 0;
        result = 31 * result + (repeat != null ? repeat.hashCode() : 0);
        return result;
    }
}
