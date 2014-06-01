package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Practitioner Id
 *
 */
public class PractitionerId implements Serializable {

    private static final long serialVersionUID = 3974850397961656194L;

    /**
     * Value
     */
    private String value;

    public PractitionerId() {
    }

    public static PractitionerId valueOf(String string) {
        return practitionerId(string);
    }

    public static PractitionerId practitionerId(String value) {

        PractitionerId practitionerId = new PractitionerId();
        practitionerId.value = value;

        return practitionerId;
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

        PractitionerId that = (PractitionerId) o;

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
