package org.celllife.idart.domain.common;

import org.celllife.idart.udm.common.ValueObject;
import org.celllife.idart.udm.party.Organisation;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public final class Identifier implements ValueObject {

    @NotNull
    private String system;

    @NotNull
    private String number;

    private Period period;

    @ManyToOne
    private Organisation assigner;

    protected Identifier() {
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Organisation getAssigner() {
        return assigner;
    }

    public void setAssigner(Organisation assigner) {
        this.assigner = assigner;
    }
}