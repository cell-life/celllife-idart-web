package org.celllife.idart.client;

import org.celllife.idart.client.medication.Medication;
import org.celllife.idart.client.part.Compound;
import org.celllife.idart.client.part.Drug;
import org.celllife.idart.client.partyrole.Patient;
import org.celllife.idart.client.partyrole.Practitioner;
import org.celllife.idart.client.prescription.Prescription;

import java.util.List;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 19h24
 */
public interface IdartClient {

    void saveMedication(Medication medication);

    void savePrescription(Prescription prescription);

    List<Patient> getPatients(String patientIdValue);

    List<Practitioner> getPractitioners();

}
