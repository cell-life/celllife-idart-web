package org.celllife.idart.application.patient;

import org.celllife.idart.domain.patient.Patient;

import java.security.Principal;
import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h38
 */
public interface PatientApplicationService {

    List<Patient> findByIdentifier(String applicationIdentifier,
                                   String idartClinicIdentifierValue,
                                   String patientIdentifierValue);

}
