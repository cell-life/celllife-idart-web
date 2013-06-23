package org.celllife.idart.domain.doctor;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 16h23
 */
public final class DoctorBuilder {

    private Doctor doctor;

    public DoctorBuilder() {
        this.doctor = new Doctor();
    }

    public void setId(Long id) {
        doctor.setPk(id);
    }

    public void addIdentifier(DoctorIdentifierType type, String value) {
        doctor.addIdentifier(type, value);
    }

    public void setFirstName(String firstName) {
        doctor.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        doctor.setLastName(lastName);
    }

    public Doctor build() {
        return doctor;
    }
}
