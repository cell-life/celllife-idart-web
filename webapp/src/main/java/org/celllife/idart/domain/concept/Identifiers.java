package org.celllife.idart.domain.concept;

import org.celllife.idart.udm.common.BaseEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-22
 * Time: 22h11
 */
@Entity
public final class Identifiers extends BaseEntity {

    /**
     * Identified by
     */
    @ElementCollection
    private Set<Identifier> identifiers;

    public Identifiers() {
    }

    public Set<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public void addIdentifier(String system, String value) {
        if (this.identifiers == null) {
            this.identifiers = new HashSet<>();
        }

        this.identifiers.add(new Identifier(system, value));
    }

    public String getFirstSystem() {
        if (this.identifiers == null || this.identifiers.isEmpty()) {
            return null;
        }

        return this.identifiers.iterator().next().getSystem();
    }

    public String getIdentifierValue(String system) {

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

    public Set<String> getIdentifierSystems() {

        Set<String> systems = new HashSet<>();
        for (Identifier identifier : identifiers) {
            systems.add(identifier.getSystem());
        }

        return systems;
    }

    public boolean hasIdentifierForSystem(String system) {

        for (Identifier identifier : identifiers) {
            if (identifier.getSystem().equals(system)) {
                return true;
            }
        }

        return false;
    }

    public void mergeIdentifiers(Identifiers that) {

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
