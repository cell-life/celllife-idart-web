package org.celllife.idart.common;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 11h17
 */
public class Duration implements Serializable {

    private BigDecimal value;

    private UnitOfMeasureCode unitOfMeasure;

    public Duration() {
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
}
