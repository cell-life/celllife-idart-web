package org.celllife.idart.domain.common;

import org.celllife.idart.domain.concept.Identifier;
import org.celllife.idart.domain.concept.Identifiers;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 14h17
 */
privileged aspect IdentifiableAspect {

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private Identifiers Identifiable.identifiers = new Identifiers();

    public Set<String> Identifiable.getIdentifierSystems() {
        return this.identifiers.getIdentifierSystems();
    }

    public String Identifiable.getIdentifierValue(String system) {
        return this.identifiers.getIdentifierValue(system);
    }

    public String Identifiable.getFirstSystem() {
        return this.identifiers.getFirstSystem();
    }

    public void Identifiable.addIdentifier(String system, String value) {
        this.identifiers.addIdentifier(system, value);
    }

    public void Identifiable.setIdentifiers(Set<Identifier> newIdentifiers) {
        this.identifiers.setIdentifiers(newIdentifiers);
    }

    public Set<Identifier> Identifiable.getIdentifiers() {
        return this.identifiers.getIdentifiers();
    }

    public boolean Identifiable.hasIdentifierForSystem(String system) {
        return this.identifiers.hasIdentifierForSystem(system);
    }

    public void Identifiable.mergeIdentifiers(Identifiable that) {
        this.identifiers.mergeIdentifiers(that.identifiers);
    }

}
