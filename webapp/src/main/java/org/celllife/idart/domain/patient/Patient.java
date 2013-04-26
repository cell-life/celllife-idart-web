package org.celllife.idart.domain.patient;

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
public final class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @JoinColumn(name = "patient")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PatientIdentifier> identifiers;

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<PatientIdentifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set<PatientIdentifier> identifiers) {
        this.identifiers = identifiers;
    }

    public void addIdentifier(String value, PatientIdentifierType type) {
        if (this.identifiers == null) {
            this.identifiers = new HashSet<>();
        }

        this.identifiers.add(new PatientIdentifier(value, type));
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", identifiers=" + identifiers +
                '}';
    }

}
