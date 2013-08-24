package org.celllife.idart.application.patient

import org.celllife.idart.domain.patient.Patient

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 12h43
 */
interface PatientProvider {

    Set<Patient> findById(String clinicIdValue, String patientIdValue)

}
