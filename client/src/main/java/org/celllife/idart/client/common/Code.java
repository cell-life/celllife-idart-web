package org.celllife.idart.client.common;

import java.io.Serializable;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h29
 */
public final class Code implements Serializable {

    public String value;

    public Code() {
    }

    public Code(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Coded{" +
                ", value='" + value + '\'' +
                '}';
    }
}
