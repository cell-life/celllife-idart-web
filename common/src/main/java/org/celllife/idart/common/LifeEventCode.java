package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Life Event Code
 *
 */
public class LifeEventCode implements Serializable {

    /**
     * Value
     */
    private String value;

    public LifeEventCode() {
    }

    public static LifeEventCode valueOf(String string) {
        return lifeEventCode(string);
    }

    public static LifeEventCode lifeEventCode(String value) {

        LifeEventCode lifeEventCode = new LifeEventCode();
        lifeEventCode.value = value;

        return lifeEventCode;
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

        LifeEventCode that = (LifeEventCode) o;

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
