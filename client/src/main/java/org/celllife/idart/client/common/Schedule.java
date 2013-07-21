package org.celllife.idart.client.common;

import java.io.Serializable;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-22
 * Time: 00h06
 */
public final class Schedule implements Serializable {

    public Set<Period> events;

    public Repeat repeat;

    public Schedule() {
    }
}
