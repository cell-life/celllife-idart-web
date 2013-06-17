package org.celllife.idart.udm.party;

import javax.persistence.Entity;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 13h50
 */
@Entity
public abstract class Organisation extends Party {

    private String name;

    protected Organisation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
