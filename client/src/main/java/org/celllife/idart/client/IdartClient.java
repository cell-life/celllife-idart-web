package org.celllife.idart.client;

import org.celllife.idart.client.clinic.Clinic;
import org.celllife.idart.client.form.Form;
import org.celllife.idart.client.part.Compound;
import org.celllife.idart.client.part.Drug;
import org.celllife.idart.client.part.FinishedGood;
import org.celllife.idart.client.part.RawMaterial;
import org.celllife.idart.client.partyrole.PartyRole;
import org.celllife.idart.client.unitofmeasure.UnitOfMeasure;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 19h24
 */
public interface IdartClient {

    void saveClinic(Clinic clinic);

    List<PartyRole> getPatients(String clinicName, String patientIdentifierValue);

    List<PartyRole> getPractitioners(String clinicName);

    List<Drug> getDrugs(String clinicName);

    List<Compound> getCompounds();

    List<Form> getForms();

    List<UnitOfMeasure> getUnitsOfMeasure();
}
