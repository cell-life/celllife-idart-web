package org.celllife.idart.common;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 21h33
 */
public class Ratio {

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
