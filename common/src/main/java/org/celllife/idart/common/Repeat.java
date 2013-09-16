package org.celllife.idart.common;

import java.util.Date;

/**
 * A schedule that specifies an event that may occur multiple times. Schedules are not used for recording when things
 * did happen, but when they are expected or requested to occur. A schedule can be either a list of events - periods on
 * which the event occurs, or a single event with repeating criteria, or just repeating criteria with no actual event.
 * <p/>
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 22h59
 */
public class Repeat {

    /**
     * Event occurs frequency times per duration
     */
    private Integer frequency;

    /**
     * Event occurs duration from common life event
     */
    private LifeEventCode when;

    /**
     * Repeating or event-related duration
     */
    private Duration duration;

    /**
     * Number of times to repeat
     */
    private Integer count;

    /**
     * When to stop repeats
     */
    private Date end;

    public Repeat() {
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public LifeEventCode getWhen() {
        return when;
    }

    public void setWhen(LifeEventCode when) {
        this.when = when;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
