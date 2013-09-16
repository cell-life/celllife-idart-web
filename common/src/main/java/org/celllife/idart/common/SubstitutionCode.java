package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * Substitution Code
 *
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public class SubstitutionCode implements Serializable {

    /**
     * Value
     */
    private String value;

    public SubstitutionCode() {
    }

    public static SubstitutionCode valueOf(String string) {
        return substitutionCode(string);
    }

    public static SubstitutionCode substitutionCode(String value) {

        SubstitutionCode substitutionCode = new SubstitutionCode();
        substitutionCode.value = value;

        return substitutionCode;
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

        SubstitutionCode that = (SubstitutionCode) o;

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
