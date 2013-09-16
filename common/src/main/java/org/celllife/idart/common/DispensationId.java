package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * Dispensation Id
 *
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public class DispensationId implements Serializable {

    /**
     * Value
     */
    private String value;

    public DispensationId() {
    }

    public static DispensationId valueOf(String string) {
        return dispensationId(string);
    }

    public static DispensationId dispensationId(String value) {

        DispensationId dispensationId = new DispensationId();
        dispensationId.value = value;

        return dispensationId;
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

        DispensationId that = (DispensationId) o;

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
