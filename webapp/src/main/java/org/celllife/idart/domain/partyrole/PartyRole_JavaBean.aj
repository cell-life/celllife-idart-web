package org.celllife.idart.domain.partyrole;

import org.celllife.idart.udm.facilityrole.PartyRoleFacility;

import java.util.Date;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 20h32
 */
privileged aspect PartyRole_JavaBean {

    public Date PartyRole.getFromDate() {
        return fromDate;
    }

    public void PartyRole.setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date PartyRole.getThruDate() {
        return thruDate;
    }

    public void PartyRole.setThruDate(Date thruDate) {
        this.thruDate = thruDate;
    }

    public Set<PartyRoleFacility> PartyRole.getFacilities() {
        return facilities;
    }

    public void PartyRole.setFacilities(Set<PartyRoleFacility> partyRoleFacilities) {
        this.facilities = partyRoleFacilities;
    }
}
