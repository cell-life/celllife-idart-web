package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Indication Code
 *
 */
public class IndicationCode implements Serializable {

    /**
     * Value
     */
    private String value;

    public IndicationCode() {
    }

    public static IndicationCode valueOf(String string) {
        return indicationCode(string);
    }

    public static IndicationCode indicationCode(String value) {

        IndicationCode indicationCode = new IndicationCode();
        indicationCode.value = value;

        return indicationCode;
    }

    @JsonValue
    public String getValue() {
         return this.value;
    }

    public void setValue(String value) {
         this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndicationCode that = (IndicationCode) o;

        if (!value.equals(that.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return getValue();
    }
}
