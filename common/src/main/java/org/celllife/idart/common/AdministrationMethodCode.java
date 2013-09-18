package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Administration Method Code
 *
 */
public class AdministrationMethodCode implements Serializable {

    /**
     * Value
     */
    private String value;

    public AdministrationMethodCode() {
    }

    public static AdministrationMethodCode valueOf(String string) {
        return administrationMethodCode(string);
    }

    public static AdministrationMethodCode administrationMethodCode(String value) {

        AdministrationMethodCode administrationMethodCode = new AdministrationMethodCode();
        administrationMethodCode.value = value;

        return administrationMethodCode;
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

        AdministrationMethodCode that = (AdministrationMethodCode) o;

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
