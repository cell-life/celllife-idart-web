package org.celllife.idart.application.patient

import org.celllife.idart.interfaces.service.patient.FindPatientsByIdentifierRequest

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h38
 */
interface PatientApplicationService {

    FindPatientsByIdentifierResponse findByIdentifier(FindPatientsByIdentifierRequest request)

}
