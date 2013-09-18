package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Unit Of Measure Code
 *
 */
public class UnitOfMeasureCode implements Serializable {

    /**
     * Value
     */
    private String value;

    public UnitOfMeasureCode() {
    }

    public static UnitOfMeasureCode valueOf(String string) {
        return unitOfMeasureCode(string);
    }

    public static UnitOfMeasureCode unitOfMeasureCode(String value) {

        UnitOfMeasureCode unitOfMeasureCode = new UnitOfMeasureCode();
        unitOfMeasureCode.value = value;

        return unitOfMeasureCode;
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

        UnitOfMeasureCode that = (UnitOfMeasureCode) o;

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
