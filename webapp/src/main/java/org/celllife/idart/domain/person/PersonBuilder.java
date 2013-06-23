package org.celllife.idart.domain.person;

import org.celllife.idart.udm.common.Gender;

import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 10h42
 */
public final class PersonBuilder {
    
    private Person person;

    public PersonBuilder() {
        this.person = new Person();
    }

    public PersonBuilder setId(Long id) {
        person.setPk(id);
        return this;
    }

    public PersonBuilder addIdentifier(String system, String value) {
        person.addIdentifier(system, value);
        return this;
    }

    public PersonBuilder setFirstName(String firstName) {
        person.setFirstName(firstName);
        return this;
    }

    public PersonBuilder setLastName(String lastName) {
        person.setLastName(lastName);
        return this;
    }

    public PersonBuilder setBirthDate(Date birthDate) {
        person.setBirthDate(birthDate);
        return this;
    }

    public PersonBuilder setGender(Gender gender) {
        person.setGender(gender);
        return this;
    }

//    public PersonBuilder setMobileNumber(String mobileNumber) {
//        person.setMobileNumber(mobileNumber);
//        return this;
//    }

    public Person build() {
        return person;
    }
}
