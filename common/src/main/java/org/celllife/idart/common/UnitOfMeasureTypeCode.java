package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Unit Of Measure Type Code
 *
 */
public class UnitOfMeasureTypeCode implements Serializable {

    private static final long serialVersionUID = 7843395437068783496L;
    
    /**
     * Value
     */
    private String value;

    public UnitOfMeasureTypeCode() {
    }

    public static UnitOfMeasureTypeCode valueOf(String string) {
        return unitOfMeasureTypeCode(string);
    }

    public static UnitOfMeasureTypeCode unitOfMeasureTypeCode(String value) {

        UnitOfMeasureTypeCode unitOfMeasureTypeCode = new UnitOfMeasureTypeCode();
        unitOfMeasureTypeCode.value = value;

        return unitOfMeasureTypeCode;
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

        UnitOfMeasureTypeCode that = (UnitOfMeasureTypeCode) o;

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
