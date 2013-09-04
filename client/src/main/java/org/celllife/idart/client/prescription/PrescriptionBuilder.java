package org.celllife.idart.client.prescription;

import org.celllife.idart.client.common.Id;
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

    private String clinicPrescriptionIdSystem;

    public PrescriptionBuilder(String clinicId) {
        this.prescription = new Prescription();
        this.clinicId = clinicId;
        this.clinicPrescriptionIdSystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/prescriptions", clinicId);
    }

    public PrescriptionBuilder setId(String prescriptionId) {
        this.prescription.ids.add(new Id(prescriptionId));
        return this;
    }

    public PrescriptionBuilder setPatient(String id) {
        this.prescription.patient = new Patient();
        this.prescription.patient.ids.add(new Id(id));
        return this;
    }

    public PrescriptionBuilder setPatient(String idSystem, String idValue) {
        this.prescription.patient = new Patient();
        this.prescription.patient.ids.add(new Id(idValue));
        return this;
    }

    public PrescriptionBuilder setPrescriber(String id) {
        this.prescription.prescriber = new Practitioner();
        this.prescription.prescriber.ids.add(new Id(id));
        return this;
    }

    public PrescriptionBuilder setPrescriber(String idSystem, String idValue) {
        this.prescription.prescriber = new Practitioner();
        this.prescription.prescriber.ids.add(new Id(idValue));
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
        this.prescription.ids.add(new Id(value));
        return this;
    }
}
