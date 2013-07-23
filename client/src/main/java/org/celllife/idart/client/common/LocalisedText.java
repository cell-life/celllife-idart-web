package org.celllife.idart.client.common;

import java.io.Serializable;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h29
 */
public final class LocalisedText implements Serializable {

    public String locale;

    public String value;

    public LocalisedText() {
    }

    @Override
    public String toString() {
        return "Coded{" +
                "locale='" + locale + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
