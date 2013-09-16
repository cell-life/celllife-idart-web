package org.celllife.idart.common;

import java.math.BigDecimal;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 11h17
 */
public class Quantity {

    private BigDecimal value;

    private UnitOfMeasureCode unitOfMeasure;

    public static Quantity newQuantity(BigDecimal value, UnitOfMeasureCode unitOfMeasure) {

        Quantity quantity = new Quantity();
        quantity.value = value;
        quantity.unitOfMeasure = unitOfMeasure;

        return quantity;
    }

    public Quantity() {
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public UnitOfMeasureCode getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasureCode unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quantity quantity = (Quantity) o;

        if (!unitOfMeasure.equals(quantity.unitOfMeasure)) return false;
        if (!value.equals(quantity.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + unitOfMeasure.hashCode();
        return result;
    }
}
