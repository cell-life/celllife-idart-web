package org.celllife.idart.client.prescription;

import org.celllife.idart.common.SystemId;

import java.util.Date;

import static org.celllife.idart.common.Identifiers.newIdentifier;
import static org.celllife.idart.common.SystemId.systemId;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-22
 * Time: 00h08
 */
public final class PrescriptionBuilder {

    private Prescription prescription;

    private SystemId systemId;

    public PrescriptionBuilder(String systemId) {
        this.prescription = new Prescription();
        this.systemId = systemId(systemId);
    }

    public PrescriptionBuilder setIdentifier(String value) {
        this.prescription.identifiers.add(newIdentifier(systemId, value));
        return this;
    }

    public PrescriptionBuilder setPatient(String value) {
        this.prescription.patient.add(newIdentifier(systemId, value));
        return this;
    }

    public PrescriptionBuilder setPatient(SystemId systemId, String value) {
        this.prescription.patient.add(newIdentifier(systemId, value));
        return this;
    }

    public PrescriptionBuilder setPrescriber(String value) {
        this.prescription.prescriber.add(newIdentifier(systemId, value));
        return this;
    }

    public PrescriptionBuilder setPrescriber(SystemId systemId, String value) {
        this.prescription.prescriber.add(newIdentifier(systemId, value));
        return this;
    }

    public PrescriptionBuilder setEncounter(String value) {
        this.prescription.encounter.add(newIdentifier(systemId, value));
        return this;
    }

    public PrescriptionBuilder setDateWritten(Date dateWritten) {
        this.prescription.dateWritten = dateWritten;
        return this;
    }

    public PrescriptionBuilder addPrescribedMedication(PrescribedMedication prescribedMedication) {
        this.prescription.prescribedMedications.add(prescribedMedication);
        return this;
    }

    public Prescription finishPrescription() {
        return this.prescription;
    }

    public PrescriptionBuilder addIdentifier(SystemId systemId, String value) {
        this.prescription.identifiers.add(newIdentifier(systemId, value));
        return this;
    }
}
