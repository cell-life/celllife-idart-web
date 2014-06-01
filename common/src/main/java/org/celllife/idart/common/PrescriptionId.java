package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Prescription Id
 *
 */
public class PrescriptionId implements Serializable {

    private static final long serialVersionUID = 5237882055530079941L;

    /**
     * Value
     */
    private String value;

    public PrescriptionId() {
    }

    public static PrescriptionId valueOf(String string) {
        return prescriptionId(string);
    }

    public static PrescriptionId prescriptionId(String value) {

        PrescriptionId prescriptionId = new PrescriptionId();
        prescriptionId.value = value;

        return prescriptionId;
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

        PrescriptionId that = (PrescriptionId) o;

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
