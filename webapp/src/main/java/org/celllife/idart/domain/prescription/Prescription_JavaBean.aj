package org.celllife.idart.domain.prescription;

import org.celllife.idart.domain.patient.Patient;
import org.celllife.idart.framework.aspectj.InjectIdentified;
import org.celllife.idart.domain.practitioner.Practitioner;

import java.util.Date;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 16h57
 */
privileged aspect Prescription_JavaBean {

    public Practitioner Prescription.getPrescriber() {
        return prescriber;
    }

    @InjectIdentified
    public void Prescription.setPrescriber(Practitioner prescriber) {
        this.prescriber = prescriber;
    }

    public Patient Prescription.getPatient() {
        return patient;
    }

    @InjectIdentified
    public void Prescription.setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date Prescription.getDateWritten() {
        return dateWritten;
    }

    public void Prescription.setDateWritten(Date dateWritten) {
        this.dateWritten = dateWritten;
    }

    public Set<PrescribedMedication> Prescription.getPrescribedMedications() {
        return prescribedMedications;
    }

    public void Prescription.setPrescribedMedications(Set<PrescribedMedication> prescribedMedications) {
        this.prescribedMedications = prescribedMedications;
    }

}
