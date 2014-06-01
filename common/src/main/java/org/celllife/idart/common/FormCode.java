package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Form Code
 *
 */
public class FormCode implements Serializable {

    private static final long serialVersionUID = 8666806278581032535L;

    /**
     * Value
     */
    private String value;

    public FormCode() {
    }

    public static FormCode valueOf(String string) {
        return formCode(string);
    }

    public static FormCode formCode(String value) {

        FormCode formCode = new FormCode();
        formCode.value = value;

        return formCode;
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

        FormCode that = (FormCode) o;

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
