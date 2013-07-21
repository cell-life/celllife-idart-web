package org.celllife.idart.client.common;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h28
 */
public final class Quantity implements Serializable {

    public BigDecimal value;

    public Coded unitOfMeasure;

}
