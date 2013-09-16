package org.celllife.idart.client.prescription;

import org.celllife.idart.common.Id;
import org.celllife.idart.client.partyrole.Patient;
import org.celllife.idart.client.partyrole.Practitioner;

import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-22
 * Time: 00h08
 */
public final class PrescriptionBuilder {

    private Prescription prescription;

    private String clinicId;

    private String clinicPrescriptionidentifiersystem;

    public PrescriptionBuilder(String clinicId) {
        this.prescription = new Prescription();
        this.clinicId = clinicId;
        this.clinicPrescriptionidentifiersystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/prescriptions", clinicId);
    }

    public PrescriptionBuilder setId(String prescriptionId) {
        this.prescription.identifiers.add(newIdentifier(prescriptionId));
        return this;
    }

    public PrescriptionBuilder setPatient(String id) {
        this.prescription.patient = new Patient();
        this.prescription.patient.identifiers.add(newIdentifier(id));
        return this;
    }

    public PrescriptionBuilder setPatient(String identifiersystem, String idValue) {
        this.prescription.patient = new Patient();
        this.prescription.patient.identifiers.add(newIdentifier(idValue));
        return this;
    }

    public PrescriptionBuilder setPrescriber(String id) {
        this.prescription.prescriber = new Practitioner();
        this.prescription.prescriber.identifiers.add(newIdentifier(id));
        return this;
    }

    public PrescriptionBuilder setPrescriber(String identifiersystem, String idValue) {
        this.prescription.prescriber = new Practitioner();
        this.prescription.prescriber.identifiers.add(newIdentifier(idValue));
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

    public PrescriptionBuilder addId(String system, String value) {
        this.prescription.identifiers.add(newIdentifier(value));
        return this;
    }
}
