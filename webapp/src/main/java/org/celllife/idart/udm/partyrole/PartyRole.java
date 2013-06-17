package org.celllife.idart.udm.partyrole;

import org.celllife.idart.udm.common.BaseEntity;
import org.celllife.idart.udm.facilityrole.PartyRoleFacility;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 09h13
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public abstract class PartyRole extends BaseEntity {

    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Temporal(TemporalType.DATE)
    private Date thruDate;

    /**
     * involved in
     */
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<PartyRoleFacility> facilities;

    protected PartyRole() {
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

    public Set<PartyRoleFacility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<PartyRoleFacility> partyRoleFacilities) {
        this.facilities = partyRoleFacilities;
    }
}
