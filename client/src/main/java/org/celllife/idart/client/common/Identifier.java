package org.celllife.idart.client.common;

import java.io.Serializable;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h24
 */
public final class Identifier implements Serializable {

    public String system;

    public String value;

    public Date fromDate;

    public Date thruDate;

    public Identifier() {
    }

    public Identifier(String system, String value) {
        this.system = system;
        this.value = value;
    }
}
