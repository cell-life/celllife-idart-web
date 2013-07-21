package org.celllife.idart.client.prescription;

import org.celllife.idart.client.common.Identifier;
import org.celllife.idart.client.partyrole.PartyRole;

import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-22
 * Time: 00h08
 */
public final class PrescriptionBuilder {

    private Prescription prescription;

    public PrescriptionBuilder() {
        this.prescription = new Prescription();
    }

    public PrescriptionBuilder setIdentifier(String clinicIdentifier, String prescriptionIdentifier) {
        String system = String.format("http://www.celllife.org/idart/clinics/%s/prescriptions", clinicIdentifier);
        this.prescription.identifiers.add(new Identifier(system, prescriptionIdentifier));
        return this;
    }

    public PrescriptionBuilder setPatient(String identifier) {
        this.prescription.patient = new PartyRole();
        this.prescription.patient.identifiers.add(new Identifier("http://www.celllife.org/idart/patients", identifier));
        return this;
    }

    public PrescriptionBuilder setPatient(String identifierSystem, String identifierValue) {
        this.prescription.patient = new PartyRole();
        this.prescription.patient.identifiers.add(new Identifier(identifierSystem, identifierValue));
        return this;
    }

    public PrescriptionBuilder setPrescriber(String identifier) {
        this.prescription.prescriber = new PartyRole();
        this.prescription.prescriber.identifiers.add(new Identifier("http://www.celllife.org/idart/practitioner", identifier));
        return this;
    }

    public PrescriptionBuilder setPrescriber(String identifierSystem, String identifierValue) {
        this.prescription.prescriber = new PartyRole();
        this.prescription.prescriber.identifiers.add(new Identifier(identifierSystem, identifierValue));
        return this;
    }

    public PrescriptionBuilder setDateWritten(Date dateWritten) {
        this.prescription.dateWritten = dateWritten;
        return this;
    }

    public PrescribedMedicationBuilder addPrescribedMedication() {
        return new PrescribedMedicationBuilder(this, prescription);
    }

    public Prescription finishPrescription() {
        return this.prescription;
    }
}
