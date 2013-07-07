package org.celllife.idart.application.practitioner

import org.celllife.idart.domain.practitioner.Practitioner

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 12h16
 */
interface PractitionerApplicationService {

    List<Practitioner> findByClinicIdentifier(String applicationId, String clinicIdentifierValue)
}
