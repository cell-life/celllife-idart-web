package org.celllife.idart.client.prescription;

import org.celllife.idart.client.common.Duration;
import org.celllife.idart.client.common.Id;
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

    private String clinicId;

    private String clinicPrescriptionIdSystem;

    public PrescriptionBuilder(String clinicId) {
        this.prescription = new Prescription();
        this.clinicId = clinicId;
        this.clinicPrescriptionIdSystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/prescriptions", clinicId);
    }

    public PrescriptionBuilder setId(String prescriptionId) {
        this.prescription.ids.add(new Id(clinicPrescriptionIdSystem, prescriptionId));
        return this;
    }

    public PrescriptionBuilder setPatient(String id) {
        this.prescription.patient = new Patient();
        this.prescription.patient.ids.add(new Id(Patient.IDART_SYSTEM, id));
        return this;
    }

    public PrescriptionBuilder setPatient(String idSystem, String idValue) {
        this.prescription.patient = new Patient();
        this.prescription.patient.ids.add(new Id(idSystem, idValue));
        return this;
    }

    public PrescriptionBuilder setPrescriber(String id) {
        this.prescription.prescriber = new Practitioner();
        this.prescription.prescriber.ids.add(new Id(Practitioner.IDART_SYSTEM, id));
        return this;
    }

    public PrescriptionBuilder setPrescriber(String idSystem, String idValue) {
        this.prescription.prescriber = new Practitioner();
        this.prescription.prescriber.ids.add(new Id(idSystem, idValue));
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
        this.prescription.ids.add(new Id(system, value));
        return this;
    }
}
