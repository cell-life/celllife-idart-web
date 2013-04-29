package org.celllife.idart.application.patient;

import org.celllife.idart.domain.patient.Patient;

import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 12h43
 */
public interface PatientProvider {

    Set<Patient> findByIdentifier(String clinicIdentifierValue, String patientIdentifierValue);

}
