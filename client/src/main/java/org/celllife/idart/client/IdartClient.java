package org.celllife.idart.client;

import org.celllife.idart.client.dispensation.Dispensation;
import org.celllife.idart.client.encounter.Encounter;
import org.celllife.idart.client.part.Part;
import org.celllife.idart.client.partyrole.Patient;
import org.celllife.idart.client.partyrole.Practitioner;
import org.celllife.idart.client.prescription.Prescription;
import org.celllife.idart.client.product.Product;

import java.util.List;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 19h24
 */
public interface IdartClient {

    void saveEncounter(Encounter encounter);

    void savePart(Part part);

    void saveProduct(Product product);

    void savePrescription(Prescription prescription);

    void saveDispensation(Dispensation dispensation);

    List<Patient> getPatients(String patientIdValue);

    List<Practitioner> getPractitioners();
}
