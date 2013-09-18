package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Encounter Id
 *
 */
public class EncounterId implements Serializable {

    /**
     * Value
     */
    private String value;

    public EncounterId() {
    }

    public static EncounterId valueOf(String string) {
        return encounterId(string);
    }

    public static EncounterId encounterId(String value) {

        EncounterId encounterId = new EncounterId();
        encounterId.value = value;

        return encounterId;
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

        EncounterId that = (EncounterId) o;

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
