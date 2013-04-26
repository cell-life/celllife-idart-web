package org.celllife.idart.domain.patient;

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

    public Patient build() {
        return patient;
    }
}
