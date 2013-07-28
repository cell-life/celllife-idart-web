package org.celllife.idart.application.prescription

import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.prescription.Prescription

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 12h43
 */
interface ClinicPrescriptionProvider {

    void save(Clinic clinic, Prescription prescription);

}
