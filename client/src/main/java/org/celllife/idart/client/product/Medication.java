package org.celllife.idart.client.product;

import org.celllife.idart.common.Identifier;

import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h57
 */
public final class Medication extends Product {

    private Set<Identifier> drug = new HashSet<Identifier>();

    public Medication() {
        super();
    }

    public Set<Identifier> getDrug() {
        return drug;
    }

    public void setDrug(Set<Identifier> drug) {
        this.drug = drug;
    }
}
