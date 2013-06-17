package org.celllife.idart.udm.partclassification;

import org.celllife.idart.udm.common.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 13h22
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PartClassification extends BaseEntity {

    private String code;

    @NotNull
    private String description;

    @ManyToOne
    private PartClassification parent;

    protected PartClassification() {
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

    public PartClassification getParent() {
        return parent;
    }

    public void setParent(PartClassification parent) {
        this.parent = parent;
    }
}
