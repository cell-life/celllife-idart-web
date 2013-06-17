package org.celllife.idart.udm.party;

import org.celllife.idart.udm.MaritalStatus;
import org.celllife.idart.udm.common.Gender;
import org.celllife.idart.udm.physicalcharacteristic.PhysicalCharacteristic;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 13h50
 */
@Entity
public final class Person extends Party {

    private String currentLastname;

    private String currentFirstName;

    private String currentMiddleName;

    private String currentPersonalTitle;

    private String currentSuffix;

    private String currentNickname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private String mothersMaidenName;

    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    private String nationalIdentityNumber;

    private String currentPassportNumber;

    @Temporal(TemporalType.DATE)
    private Date currentPassportExpireDate;

    private Integer totalYearsWorkExperience;

    private String comment;

    /**
     * having
     */
    @JoinColumn(name = "person")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<PhysicalCharacteristic> physicalCharacteristics;

    public Person() {
    }

    public String getCurrentLastname() {
        return currentLastname;
    }

    public void setCurrentLastname(String currentLastname) {
        this.currentLastname = currentLastname;
    }

    public String getCurrentFirstName() {
        return currentFirstName;
    }

    public void setCurrentFirstName(String currentFirstName) {
        this.currentFirstName = currentFirstName;
    }

    public String getCurrentMiddleName() {
        return currentMiddleName;
    }

    public void setCurrentMiddleName(String currentMiddleName) {
        this.currentMiddleName = currentMiddleName;
    }

    public String getCurrentPersonalTitle() {
        return currentPersonalTitle;
    }

    public void setCurrentPersonalTitle(String currentPersonalTitle) {
        this.currentPersonalTitle = currentPersonalTitle;
    }

    public String getCurrentSuffix() {
        return currentSuffix;
    }

    public void setCurrentSuffix(String currentSuffix) {
        this.currentSuffix = currentSuffix;
    }

    public String getCurrentNickname() {
        return currentNickname;
    }

    public void setCurrentNickname(String currentNickname) {
        this.currentNickname = currentNickname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getMothersMaidenName() {
        return mothersMaidenName;
    }

    public void setMothersMaidenName(String mothersMaidenName) {
        this.mothersMaidenName = mothersMaidenName;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNationalIdentityNumber() {
        return nationalIdentityNumber;
    }

    public void setNationalIdentityNumber(String nationalIdentityNumber) {
        this.nationalIdentityNumber = nationalIdentityNumber;
    }

    public String getCurrentPassportNumber() {
        return currentPassportNumber;
    }

    public void setCurrentPassportNumber(String currentPassportNumber) {
        this.currentPassportNumber = currentPassportNumber;
    }

    public Date getCurrentPassportExpireDate() {
        return currentPassportExpireDate;
    }

    public void setCurrentPassportExpireDate(Date currentPassportExpireDate) {
        this.currentPassportExpireDate = currentPassportExpireDate;
    }

    public Integer getTotalYearsWorkExperience() {
        return totalYearsWorkExperience;
    }

    public void setTotalYearsWorkExperience(Integer totalYearsWorkExperience) {
        this.totalYearsWorkExperience = totalYearsWorkExperience;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<PhysicalCharacteristic> getPhysicalCharacteristics() {
        return physicalCharacteristics;
    }

    public void setPhysicalCharacteristics(Set<PhysicalCharacteristic> physicalCharacteristics) {
        this.physicalCharacteristics = physicalCharacteristics;
    }
}
