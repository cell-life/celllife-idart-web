package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * PrescribedMedication Id
 *
 */
public class PrescribedMedicationId implements Serializable {

    private static final long serialVersionUID = -3193763384452043470L;

    /**
     * Value
     */
    private String value;

    public PrescribedMedicationId() {
    }

    public static PrescribedMedicationId valueOf(String string) {
        return prescribedMedicationId(string);
    }

    public static PrescribedMedicationId prescribedMedicationId(String value) {

        PrescribedMedicationId prescribedMedicationId = new PrescribedMedicationId();
        prescribedMedicationId.value = value;

        return prescribedMedicationId;
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

        PrescribedMedicationId that = (PrescribedMedicationId) o;

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
