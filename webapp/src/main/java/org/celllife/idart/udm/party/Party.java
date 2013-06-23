package org.celllife.idart.udm.party;

import org.celllife.idart.domain.common.Identifiable;
import org.celllife.idart.domain.common.Persistable;

import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 13h45
 */
public abstract class Party implements Persistable, Identifiable {

    /**
     * Classified into
     */
    private Set<PartyClassificationApplication> classifications;

    protected Party() {
        super();
    }

    public Set<PartyClassificationApplication> getClassifications() {
        return classifications;
    }

    public void setClassifications(Set<PartyClassificationApplication> classifications) {
        this.classifications = classifications;
    }
}
