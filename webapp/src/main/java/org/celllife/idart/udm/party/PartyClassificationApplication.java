package org.celllife.idart.udm.party;

import org.celllife.idart.udm.common.ValueObject;
import org.celllife.idart.udm.partyclassification.PartyClassification;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 10h23
 */
@Embeddable
@Inheritance
@DiscriminatorColumn(name = "type")
public abstract class PartyClassificationApplication implements ValueObject {

    /**
     * described by
     */
    @ManyToOne
    private PartyClassification classification;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Temporal(TemporalType.DATE)
    private Date thruDate;

    protected PartyClassificationApplication() {
    }

    public PartyClassification getClassification() {
        return classification;
    }

    public void setClassification(PartyClassification partyClassification) {
        this.classification = partyClassification;
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
