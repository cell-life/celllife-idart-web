package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * Entry Site Code
 *
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public class EntrySiteCode implements Serializable {

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
