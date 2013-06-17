package org.celllife.idart.udm.party;

import org.celllife.idart.domain.common.Identifier;
import org.celllife.idart.udm.common.BaseEntity;
import org.celllife.idart.udm.partyrole.PartyRole;

import javax.persistence.*;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 13h45
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Party extends BaseEntity {

    /**
     * Identified by
     */
    @ElementCollection
    private Set<Identifier> identifiers;

    /**
     * Acting as
     */
    @JoinColumn(name = "party")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<PartyRole> roles;

    /**
     * Classified into
     */
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<PartyClassificationApplication> classifications;

    protected Party() {
        super();
    }

    public Set<PartyRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<PartyRole> roles) {
        this.roles = roles;
    }

    public Set<PartyClassificationApplication> getClassifications() {
        return classifications;
    }

    public void setClassifications(Set<PartyClassificationApplication> classifications) {
        this.classifications = classifications;
    }

    public Set<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set<Identifier> identifiers) {
        this.identifiers = identifiers;
    }
}
