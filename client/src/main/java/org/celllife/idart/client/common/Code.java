package org.celllife.idart.client.common;

import java.io.Serializable;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h29
 */
public final class Code implements Serializable {

    public String system;

    public String value;

    public Code() {
    }

    public Code(String system, String value) {
        this.system = system;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Coded{" +
                "system='" + system + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
