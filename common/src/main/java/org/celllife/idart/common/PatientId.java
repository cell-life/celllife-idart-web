package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Patient Id
 *
 */
public class PatientId implements Serializable {

    private static final long serialVersionUID = 299156160503092701L;
    
    /**
     * Value
     */
    private String value;

    public PatientId() {
    }

    public static PatientId valueOf(String string) {
        return patientId(string);
    }

    public static PatientId patientId(String value) {

        PatientId patientId = new PatientId();
        patientId.value = value;

        return patientId;
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

        PatientId that = (PatientId) o;

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
