package org.celllife.idart.client.prescription;

import org.celllife.idart.client.common.Duration;
import org.celllife.idart.client.common.Identifier;
import org.celllife.idart.client.common.Quantity;
import org.celllife.idart.client.dosageinstruction.DosageInstruction;
import org.celllife.idart.client.partyrole.PartyRole;
import org.celllife.idart.client.partyrole.Patient;
import org.celllife.idart.client.partyrole.Practitioner;
import org.celllife.idart.client.unitofmeasure.UnitOfMeasure;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-22
 * Time: 00h08
 */
public final class PrescriptionBuilder {

    private Prescription prescription;

    private String clinicIdentifier;

    private String clinicPrescriptionIdentifierSystem;

    public PrescriptionBuilder(String clinicIdentifier) {
        this.prescription = new Prescription();
        this.clinicIdentifier = clinicIdentifier;
        this.clinicPrescriptionIdentifierSystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/prescriptions", clinicIdentifier);
    }

    public PrescriptionBuilder setIdentifier(String prescriptionIdentifier) {
        this.prescription.identifiers.add(new Identifier(clinicPrescriptionIdentifierSystem, prescriptionIdentifier));
        return this;
    }

    public PrescriptionBuilder setPatient(String identifier) {
        this.prescription.patient = new Patient();
        this.prescription.patient.identifiers.add(new Identifier(Patient.IDART_SYSTEM, identifier));
        return this;
    }

    public PrescriptionBuilder setPatient(String identifierSystem, String identifierValue) {
        this.prescription.patient = new Patient();
        this.prescription.patient.identifiers.add(new Identifier(identifierSystem, identifierValue));
        return this;
    }

    public PrescriptionBuilder setPrescriber(String identifier) {
        this.prescription.prescriber = new Practitioner();
        this.prescription.prescriber.identifiers.add(new Identifier(Practitioner.IDART_SYSTEM, identifier));
        return this;
    }

    public PrescriptionBuilder setPrescriber(String identifierSystem, String identifierValue) {
        this.prescription.prescriber = new Practitioner();
        this.prescription.prescriber.identifiers.add(new Identifier(identifierSystem, identifierValue));
        return this;
    }

    public PrescriptionBuilder setDateWritten(Date dateWritten) {
        this.prescription.dateWritten = dateWritten;
        return this;
    }

    public PrescribedMedicationBuilder addPrescribedMedication() {
        return new PrescribedMedicationBuilder(this, prescription, clinicIdentifier);
    }

    public Prescription finishPrescription() {
        return this.prescription;
    }
}
