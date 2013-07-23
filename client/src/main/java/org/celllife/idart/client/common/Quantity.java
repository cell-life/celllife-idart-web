package org.celllife.idart.client.common;

import org.celllife.idart.client.unitofmeasure.UnitOfMeasure;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h28
 */
public final class Quantity implements Serializable {

    public BigDecimal value;

    public UnitOfMeasure unitOfMeasure;

    public Quantity() {

    }
}
