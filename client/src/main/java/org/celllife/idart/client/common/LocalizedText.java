package org.celllife.idart.client.common;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h29
 */
public final class LocalizedText implements Serializable {

    public String locale;

    public String value;

    public LocalizedText() {
    }

    @Override
    public String toString() {
        return "Coded{" +
                "locale='" + locale + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
