package org.celllife.idart.udm.common;

import org.celllife.idart.udm.codedconcept.UnitOfMeasure;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 11h17
 */
@Embeddable
public final class Duration implements ValueObject {

    private BigDecimal value;

    @ManyToOne
    private UnitOfMeasure unitOfMeasure;

    public Duration() {
    }

    public Duration(BigDecimal value, UnitOfMeasure unitOfMeasure) {
        this.value = value;
        this.unitOfMeasure = unitOfMeasure;
    }

    public Duration(Double value, UnitOfMeasure unitOfMeasure) {
        this.value = new BigDecimal(value);
        this.unitOfMeasure = unitOfMeasure;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
