package org.celllife.idart.application.patient

import org.celllife.idart.application.patient.dto.PatientDto

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 12h43
 */
interface PatientProvider {

    Set<PatientDto> findByIdentifier(String clinicIdentifierValue, String patientIdentifierValue)

}
