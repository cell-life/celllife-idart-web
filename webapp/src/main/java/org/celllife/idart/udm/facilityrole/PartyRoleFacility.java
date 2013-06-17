package org.celllife.idart.udm.facilityrole;

import org.celllife.idart.udm.common.ValueObject;
import org.celllife.idart.udm.facility.Facility;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 11h22
 */
@Embeddable
@Inheritance
@DiscriminatorColumn(name = "type")
public abstract class PartyRoleFacility implements ValueObject {

    /**
     * Involving
     */
    @NotNull
    @ManyToOne
    private Facility facility;

    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date thruDate;

    protected PartyRoleFacility() {
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
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
