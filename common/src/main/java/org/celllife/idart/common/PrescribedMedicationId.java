package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * PrescribedMedication Id
 *
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public class PrescribedMedicationId implements Serializable {

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
