package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Part Id
 *
 */
public class PartId implements Serializable {

    private static final long serialVersionUID = 3504082420288878223L;

    /**
     * Value
     */
    private String value;

    public PartId() {
    }

    public static PartId valueOf(String string) {
        return partId(string);
    }

    public static PartId partId(String value) {

        PartId partId = new PartId();
        partId.value = value;

        return partId;
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

        PartId that = (PartId) o;

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
