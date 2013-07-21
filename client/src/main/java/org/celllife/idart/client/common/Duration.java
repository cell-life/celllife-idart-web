package org.celllife.idart.client.common;

import org.celllife.idart.client.unitofmeasure.UnitOfMeasure;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h56
 */
public final class Duration implements Serializable {

    public BigDecimal value;

    public UnitOfMeasure unitOfMeasure;

    public Duration() {
    }
}
