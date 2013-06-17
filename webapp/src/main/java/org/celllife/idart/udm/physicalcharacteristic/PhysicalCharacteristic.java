package org.celllife.idart.udm.physicalcharacteristic;

import org.celllife.idart.udm.common.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 14h06
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PhysicalCharacteristic extends BaseEntity {

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Temporal(TemporalType.DATE)
    private Date thruDate;

    protected PhysicalCharacteristic() {
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
}
