package org.celllife.idart.udm.product;

import org.celllife.idart.domain.common.Identifier;
import org.celllife.idart.udm.part.FinishedGood;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h14
 */
@Entity
public final class Good extends Product {

    /**
     * Identified by
     */
    @ElementCollection
    private Set<Identifier> identifiers;

    /**
     * Offered using
     */
    @NotNull
    @ManyToOne(optional = false)
    private FinishedGood finishedGood;

    public Good() {
    }

    public Good(String name, FinishedGood finishedGood) {
        super(name);
        this.finishedGood = finishedGood;
    }

    public Set<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public FinishedGood getFinishedGood() {
        return finishedGood;
    }

    public void setFinishedGood(FinishedGood finishedGood) {
        this.finishedGood = finishedGood;
    }
}
