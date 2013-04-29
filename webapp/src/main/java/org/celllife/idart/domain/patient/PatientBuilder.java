package org.celllife.idart.domain.patient;

import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 16h33
 */
public final class PatientBuilder {

    private Patient patient;

    public PatientBuilder() {
        this.patient = new Patient();
    }

    public PatientBuilder setId(Long id) {
        patient.setId(id);
        return this;
    }

    public PatientBuilder addIdentifier(String value, PatientIdentifierType type) {
        patient.addIdentifier(value, type);
        return this;
    }

    public PatientBuilder setFirstName(String firstName) {
        patient.setFirstName(firstName);
        return this;
    }

    public PatientBuilder setLastName(String lastName) {
        patient.setLastName(lastName);
        return this;
    }

    public PatientBuilder setDataOfBirth(Date dataOfBirth) {
        patient.setDataOfBirth(dataOfBirth);
        return this;
    }

    public PatientBuilder setGender(Gender gender) {
        patient.setGender(gender);
        return this;
    }

    public PatientBuilder setMobileNumber(String mobileNumber) {
        patient.setMobileNumber(mobileNumber);
        return this;
    }

    public Patient build() {
        return patient;
    }
}
