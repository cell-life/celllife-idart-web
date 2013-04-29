package org.celllife.idart.domain.clinic;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h42
 */
@Entity
public final class Clinic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @JoinColumn(name = "clinic")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<ClinicIdentifier> identifiers;

    public Clinic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ClinicIdentifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set<ClinicIdentifier> identifiers) {
        this.identifiers = identifiers;
    }

    public void addIdentifier(String value, ClinicIdentifierType type) {
        if (this.identifiers == null) {
            this.identifiers = new HashSet<>();
        }

        this.identifiers.add(new ClinicIdentifier(value, type));
    }

    public Set<ClinicIdentifierType> getIdentifierTypes() {

        Set<ClinicIdentifierType> identifierTypes = new HashSet<>();
        for (ClinicIdentifier identifier : identifiers) {
            identifierTypes.add(identifier.getType());
        }

        return identifierTypes;
    }

    public String getIdentifierValue(ClinicIdentifierType identifierType) {

        for (ClinicIdentifier identifier : identifiers) {
            if (identifier.getType() == identifierType) {
                return identifier.getValue();
            }
        }

        return null;
    }
}
