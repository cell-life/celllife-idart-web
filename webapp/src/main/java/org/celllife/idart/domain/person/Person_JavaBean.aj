package org.celllife.idart.domain.person;

import org.celllife.idart.udm.MaritalStatus;
import org.celllife.idart.udm.common.Gender;
import org.celllife.idart.udm.physicalcharacteristic.PhysicalCharacteristic;

import java.util.Date;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 19h23
 */
privileged aspect Person_JavaBean {

    public String Person.getLastName() {
        return lastName;
    }

    public void Person.setLastName(String currentLastname) {
        this.lastName = currentLastname;
    }

    public String Person.getFirstName() {
        return firstName;
    }

    public void Person.setFirstName(String currentFirstName) {
        this.firstName = currentFirstName;
    }

    public String Person.getMiddleNames() {
        return middleNames;
    }

    public void Person.setMiddleNames(String currentMiddleName) {
        this.middleNames = currentMiddleName;
    }

    public String Person.getPersonalTitle() {
        return personalTitle;
    }

    public void Person.setPersonalTitle(String currentPersonalTitle) {
        this.personalTitle = currentPersonalTitle;
    }

    public String Person.getSuffix() {
        return suffix;
    }

    public void Person.setSuffix(String currentSuffix) {
        this.suffix = currentSuffix;
    }

    public String Person.getNickname() {
        return nickname;
    }

    public void Person.setNickname(String currentNickname) {
        this.nickname = currentNickname;
    }

    public Gender Person.getGender() {
        return gender;
    }

    public void Person.setGender(Gender gender) {
        this.gender = gender;
    }

    public Date Person.getBirthDate() {
        return birthDate;
    }

    public void Person.setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String Person.getMothersMaidenName() {
        return mothersMaidenName;
    }

    public void Person.setMothersMaidenName(String mothersMaidenName) {
        this.mothersMaidenName = mothersMaidenName;
    }

    public MaritalStatus Person.getMaritalStatus() {
        return maritalStatus;
    }

    public void Person.setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer Person.getTotalYearsWorkExperience() {
        return totalYearsWorkExperience;
    }

    public void Person.setTotalYearsWorkExperience(Integer totalYearsWorkExperience) {
        this.totalYearsWorkExperience = totalYearsWorkExperience;
    }

    public String Person.getComment() {
        return comment;
    }

    public void Person.setComment(String comment) {
        this.comment = comment;
    }

    public Set<PhysicalCharacteristic> Person.getPhysicalCharacteristics() {
        return physicalCharacteristics;
    }

    public void Person.setPhysicalCharacteristics(Set<PhysicalCharacteristic> physicalCharacteristics) {
        this.physicalCharacteristics = physicalCharacteristics;
    }
}
