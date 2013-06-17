package org.celllife.idart.udm.product;

import org.celllife.idart.udm.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h13
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product extends BaseEntity {

    @NotNull
    private String name;

    private String comment;

    protected Product() {
    }

    protected Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
