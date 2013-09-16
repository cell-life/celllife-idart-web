package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * Substitution Reason Code
 *
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public class SubstitutionReasonCode implements Serializable {

    /**
     * Value
     */
    private String value;

    public SubstitutionReasonCode() {
    }

    public static SubstitutionReasonCode valueOf(String string) {
        return substitutionReasonCode(string);
    }

    public static SubstitutionReasonCode substitutionReasonCode(String value) {

        SubstitutionReasonCode substitutionReasonCode = new SubstitutionReasonCode();
        substitutionReasonCode.value = value;

        return substitutionReasonCode;
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

        SubstitutionReasonCode that = (SubstitutionReasonCode) o;

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
