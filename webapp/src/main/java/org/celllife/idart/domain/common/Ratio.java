package org.celllife.idart.domain.common;

import org.celllife.idart.udm.common.Quantity;
import org.celllife.idart.udm.common.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 21h33
 */
@Embeddable
public final class Ratio implements ValueObject {

    private Quantity numerator;

    private Quantity denominator;

    public Ratio() {
    }

    public Quantity getNumerator() {
        return numerator;
    }

    public void setNumerator(Quantity numerator) {
        this.numerator = numerator;
    }

    public Quantity getDenominator() {
        return denominator;
    }

    public void setDenominator(Quantity denominator) {
        this.denominator = denominator;
    }
}
