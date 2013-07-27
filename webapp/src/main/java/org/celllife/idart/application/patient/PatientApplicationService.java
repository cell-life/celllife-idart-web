package org.celllife.idart.application.patient;

import org.celllife.idart.domain.patient.Patient;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 00h43
 */
public interface PatientApplicationService {

    List<Patient> findByIdentifier(String clinicIdentifier, String patientIdentifier);

}