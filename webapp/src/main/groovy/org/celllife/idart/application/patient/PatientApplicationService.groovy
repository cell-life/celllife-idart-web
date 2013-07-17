package org.celllife.idart.application.patient

import org.celllife.idart.domain.patient.Patient

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h38
 */
interface PatientApplicationService {

    List<Patient> findByIdentifier(String applicationId, String clinicIdentifier, String patientIdentifier)

    Patient save(Patient patient)

}
