package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Entry Site Code
 *
 */
public class EntrySiteCode implements Serializable {

    private static final long serialVersionUID = 4003352343438202810L;

    /**
     * Value
     */
    private String value;

    public EntrySiteCode() {
    }

    public static EntrySiteCode valueOf(String string) {
        return entrySiteCode(string);
    }

    public static EntrySiteCode entrySiteCode(String value) {

        EntrySiteCode entrySiteCode = new EntrySiteCode();
        entrySiteCode.value = value;

        return entrySiteCode;
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

        EntrySiteCode that = (EntrySiteCode) o;

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
