package org.celllife.idart.domain.common;

import org.celllife.idart.domain.concept.Identifier;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 14h17
 */
privileged aspect IdentifiableAspect {

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Identifier> Identifiable.identifiers = new HashSet<>();


    public Set<Identifier> Identifiable.getIdentifiers() {
        return identifiers;
    }

    public void Identifiable.setIdentifiers(Set<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public void Identifiable.addIdentifier(String system, String value) {
        if (this.identifiers == null) {
            this.identifiers = new HashSet<>();
        }

        this.identifiers.add(new Identifier(system, value));
    }

    public String Identifiable.getFirstSystem() {
        if (this.identifiers == null || this.identifiers.isEmpty()) {
            return null;
        }

        return this.identifiers.iterator().next().getSystem();
    }

    public String Identifiable.getIdentifierValue(String system) {

        if (system == null) {
            return null;
        }

        for (Identifier identifier : identifiers) {
            if (identifier.getSystem().equals(system)) {
                return identifier.getValue();
            }
        }

        return null;
    }

    public Set<String> Identifiable.getIdentifierSystems() {

        Set<String> systems = new HashSet<>();
        for (Identifier identifier : identifiers) {
            systems.add(identifier.getSystem());
        }

        return systems;
    }

    public boolean Identifiable.hasIdentifierForSystem(String system) {

        for (Identifier identifier : identifiers) {
            if (identifier.getSystem().equals(system)) {
                return true;
            }
        }

        return false;
    }

    public void Identifiable.mergeIdentifiers(Identifiable that) {

        if (!this.getClass().isAssignableFrom(that.getClass())) {
            throw new RuntimeException(
                    String.format(
                            "Incompatible IdentifiableConcept Types: this[%s] that[%s]",
                            this.getClass(),
                            that.getClass()
                    )
            );
        }

        for (String system : that.getIdentifierSystems()) {
            this.addIdentifier(system, that.getIdentifierValue(system));
        }
    }
}
