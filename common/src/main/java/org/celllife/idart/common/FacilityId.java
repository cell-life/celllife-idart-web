package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Facility Id
 *
 */
public class FacilityId implements Serializable {

    /**
     * Value
     */
    private String value;

    public FacilityId() {
    }

    public static FacilityId valueOf(String string) {
        return facilityId(string);
    }

    public static FacilityId facilityId(String value) {

        FacilityId facilityId = new FacilityId();
        facilityId.value = value;

        return facilityId;
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

        FacilityId that = (FacilityId) o;

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
