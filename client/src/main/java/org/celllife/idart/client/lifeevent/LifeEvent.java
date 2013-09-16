package org.celllife.idart.client.lifeevent;

import org.celllife.idart.common.LifeEventCode;

import java.io.Serializable;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h57
 */
public final class LifeEvent implements Serializable {

    public LifeEventCode code;

    public String name;

    public String description;

    public LifeEvent() {
    }
}
