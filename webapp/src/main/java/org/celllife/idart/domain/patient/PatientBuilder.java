package org.celllife.idart.domain.patient;

import org.celllife.idart.domain.person.Person;

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

    public PatientBuilder addIdentifier(String system, String value) {
        patient.addIdentifier(system, value);
        return this;
    }

    public PatientBuilder setPerson(Person person) {
        patient.setPerson(person);
        return this;
    }

    public Patient build() {
        return patient;
    }
}
