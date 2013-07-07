package org.celllife.idart.application.practitioner

import org.celllife.idart.domain.practitioner.Practitioner

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 16h02
 */
interface PractitionerProvider {

    Set<Practitioner> findAll(String clinicIdentifierValue)
}
