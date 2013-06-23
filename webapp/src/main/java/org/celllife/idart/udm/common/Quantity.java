package org.celllife.idart.udm.common;

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure;
import org.celllife.idart.framework.aspectj.InjectCoded;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 11h17
 */
@Embeddable
public final class Quantity implements ValueObject {

    private BigDecimal value;

    @ManyToOne
    private UnitOfMeasure unitOfMeasure;

    public Quantity() {
    }

    public Quantity(BigDecimal value, UnitOfMeasure unitOfMeasure) {
        this.value = value;
        this.unitOfMeasure = unitOfMeasure;
    }

    public Quantity(Double value, UnitOfMeasure unitOfMeasure) {
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

    @InjectCoded
    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
