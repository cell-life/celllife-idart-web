package org.celllife.idart.client.part;

import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 10h23
 */
public final class PartClassification {

    public PartClassificationType type;

    public String code;

    public Date fromDate;

    public Date thruDate;

    public PartClassification() {
    }

    @Override
    public String toString() {
        return "PartClassification{" +
                "type=" + type +
                ", code='" + code + '\'' +
                ", fromDate=" + fromDate +
                ", thruDate=" + thruDate +
                '}';
    }
}