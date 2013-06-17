package org.celllife.idart.udm.partyclassification;

import org.celllife.idart.udm.common.BaseEntity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 10h30
 */
@Entity
@Inheritance
@DiscriminatorColumn(name = "type")
public abstract class PartyClassification extends BaseEntity {

    private String code;

    @NotNull
    private String description;

    @ManyToOne
    private PartyClassification parent;

    protected PartyClassification() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PartyClassification getParent() {
        return parent;
    }

    public void setParent(PartyClassification parent) {
        this.parent = parent;
    }
}
