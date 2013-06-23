package org.celllife.idart.domain.concept;

import org.celllife.idart.domain.common.Period;
import org.celllife.idart.udm.common.ValueObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Embeddable
public final class Identifier implements ValueObject {

    @NotNull
    private String system;

    @NotNull
    private String value;

    @AttributeOverrides({
            @AttributeOverride(name = "fromDate", column = @Column(name = "validFromDate")),
            @AttributeOverride(name = "thruDate", column = @Column(name = "validThruDate"))
    })
    private Period valid;

//    @ManyToOne
//    private Organisation assigner;

    public Identifier() {
    }

    public Identifier(String system, String value) {
        this.system = system;
        this.value = value;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String number) {
        this.value = number;
    }

    public Period getValid() {
        return valid;
    }

    public void setValid(Period period) {
        this.valid = period;
    }

}