package org.celllife.idart.domain.patient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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

    private String firstName;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date dataOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String mobileNumber;

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

    public void addIdentifier(String value, String type) {
        if (this.identifiers == null) {
            this.identifiers = new HashSet<>();
        }

        this.identifiers.add(new PatientIdentifier(value, type));
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

    public Date getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(Date dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", identifiers=" + identifiers +
                '}';
    }

}
