package org.celllife.idart.client.common;

import org.celllife.idart.client.lifeevent.LifeEvent;

import java.io.Serializable;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-22
 * Time: 00h07
 */
public final class Repeat implements Serializable {

    public Integer frequency;

    public LifeEvent when;

    public Duration duration;

    public Integer count;

    public Date end;

    public Repeat() {
    }
}
