package org.celllife.idart.domain.partyrole;

import org.celllife.idart.domain.common.Identifiable;
import org.celllife.idart.domain.common.Persistable;
import org.celllife.idart.udm.facilityrole.PartyRoleFacility;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 09h13
 */
public abstract class PartyRole implements Persistable, Identifiable {

    /**
     * From date
     */
    @NotNull
    private Date fromDate;

    /**
     * Thru date
     */
    private Date thruDate;

    /**
     * involved in
     */
    private Set<PartyRoleFacility> facilities;

    protected PartyRole() {
        this.fromDate = new Date();
    }
}
