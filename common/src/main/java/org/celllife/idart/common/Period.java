package org.celllife.idart.common;

import java.io.Serializable;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 21h33
 */
public class Period implements Serializable {

    private static final long serialVersionUID = -6713183500610420645L;

    private Date fromDate;

    private Date thruDate;

    public Period() {
    }

    public static Period newPeriod() {

        Period period = new Period();
        period.fromDate = new Date();

        return period;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getThruDate() {
        return thruDate;
    }

    public void setThruDate(Date thruDate) {
        this.thruDate = thruDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Period period = (Period) o;

        if (fromDate != null ? !fromDate.equals(period.fromDate) : period.fromDate != null) return false;
        if (thruDate != null ? !thruDate.equals(period.thruDate) : period.thruDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fromDate != null ? fromDate.hashCode() : 0;
        result = 31 * result + (thruDate != null ? thruDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Period [fromDate=" + fromDate + ", thruDate=" + thruDate + "]";
    }
}
