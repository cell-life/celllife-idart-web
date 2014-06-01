package org.celllife.idart.common;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 21h33
 */
public class Ratio  implements Serializable {

    private static final long serialVersionUID = 4566242085603645332L;

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
