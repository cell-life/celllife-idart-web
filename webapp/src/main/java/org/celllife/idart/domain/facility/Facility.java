package org.celllife.idart.domain.facility;

import org.celllife.idart.domain.common.*;
import org.celllife.idart.udm.common.Quantity;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 11h03
 */
public abstract class Facility implements Persistable, Identifiable, Nameable {

    private Quantity area;

    protected Facility() {
    }

    public Quantity getArea() {
        return area;
    }

    public void setArea(Quantity area) {
        this.area = area;
    }
}
