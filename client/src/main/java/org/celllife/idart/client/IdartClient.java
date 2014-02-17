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
 * Handy iDARTweb utility class for clients to use. Encapsulates the REST service to make it easy
 * to use in other Java applications.
 */
public interface IdartClient {

    /**
     * Saves the patient's clinic visit details
     * @param encounter Encounter
     */
    void saveEncounter(Encounter encounter);

    /**
     * Saves the drug details (e.g. the compound(s))
     * @param part
     */
    void savePart(Part part);

    /**
     * Saves the specified medication
     * @param product Product
     */
    void saveProduct(Product product);

    /**
     * Saves the specified prescription in iDARTweb and other 3rd party integrated systems
     * @param prescription
     */
    void savePrescription(Prescription prescription);
    
    /**
     * Deletes the specified prescription and ensures that the prescription is deleted in the integrated 3rd party systems
     * @param prescription
     */
    void deletePrescription(Prescription prescription);

    /**
     * Saves the details of the dispensed package
     * @param dispensation
     */
    void saveDispensation(Dispensation dispensation);
    
    /**
     * Deletes a dispensed package that was not yet given to a patient
     * @param dispensation
     */
    void deleteDispensation(Dispensation dispensation);

    /**
     * Gets a list of all the patients created in a 3rd party integrated system (e.g. PREHMIS)
     * @param patientIdValue
     * @return
     */
    List<Patient> getPatients(String patientIdValue);

    /**
     * Gets a list of Practitioners available in linked integrated systems specific to the clinic making the request 
     * @return
     */
    List<Practitioner> getPractitioners();
}
