package org.celllife.idart.domain.doctor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 10h44
 */
@Entity
public final class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(columnDefinition = "BIT")
    private Boolean active = true;

    @JoinColumn(name = "Doctor")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<DoctorIdentifier> identifiers;

    private String firstName;

    private String lastName;

    public Doctor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<DoctorIdentifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set<DoctorIdentifier> identifiers) {
        this.identifiers = identifiers;
    }

    public void addIdentifier(String value, DoctorIdentifierType type) {
        if (this.identifiers == null) {
            this.identifiers = new HashSet<>();
        }

        this.identifiers.add(new DoctorIdentifier(value, type));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
