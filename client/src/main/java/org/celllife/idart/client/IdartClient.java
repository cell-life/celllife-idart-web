package org.celllife.idart.client;

import org.celllife.idart.client.clinic.Clinic;
import org.celllife.idart.client.form.Form;
import org.celllife.idart.client.medication.Medication;
import org.celllife.idart.client.part.Compound;
import org.celllife.idart.client.part.Drug;
import org.celllife.idart.client.partyrole.PartyRole;
import org.celllife.idart.client.partyrole.Patient;
import org.celllife.idart.client.partyrole.Practitioner;
import org.celllife.idart.client.prescription.Prescription;
import org.celllife.idart.client.unitofmeasure.UnitOfMeasure;

import java.util.List;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 19h24
 */
public interface IdartClient {

    void saveClinic(Clinic clinic);

    void saveMedication(String clinicIdentifier, Medication medication);

    void savePrescription(String clinicIdentifier, Prescription prescription);

    List<Patient> getPatients(String clinicName, String patientIdentifierValue);

    List<Practitioner> getPractitioners(String clinicName);

    List<Drug> getDrugs(String clinicName);

    List<Compound> getCompounds();

    List<Form> getForms();

    List<UnitOfMeasure> getUnitsOfMeasure();
}
