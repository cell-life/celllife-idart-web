package org.celllife.idart.domain.common;

import org.celllife.idart.udm.codedconcept.LifeEvent;
import org.celllife.idart.udm.common.Duration;
import org.celllife.idart.udm.common.ValueObject;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 21h33
 */
@Embeddable
public final class Schedule implements ValueObject {

    @CollectionTable
    @ElementCollection
    private Set<Period> events;

    private Integer frequency;

    @ManyToOne
    private LifeEvent when;

    private Duration duration;

    private Integer count;

    private Date end;

    public Schedule() {
    }

    public Set<Period> getEvents() {
        return events;
    }

    public void setEvents(Set<Period> events) {
        this.events = events;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public LifeEvent getWhen() {
        return when;
    }

    public void setWhen(LifeEvent when) {
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
