package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Default Dosage Instruction Id
 *
 */
public class DefaultDosageInstructionId implements Serializable {

    private static final long serialVersionUID = 512226931904513335L;

    /**
     * Value
     */
    private String value;

    public DefaultDosageInstructionId() {
    }

    public static DefaultDosageInstructionId valueOf(String string) {
        return defaultDosageInstructionId(string);
    }

    public static DefaultDosageInstructionId defaultDosageInstructionId(String value) {

        DefaultDosageInstructionId defaultDosageInstructionId = new DefaultDosageInstructionId();
        defaultDosageInstructionId.value = value;

        return defaultDosageInstructionId;
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

        DefaultDosageInstructionId that = (DefaultDosageInstructionId) o;

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
