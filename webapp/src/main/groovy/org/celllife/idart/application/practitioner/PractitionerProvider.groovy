package org.celllife.idart.application.practitioner

import org.celllife.idart.application.practitioner.dto.PractitionerDto

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 16h02
 */
interface PractitionerProvider {

    Set<PractitionerDto> findAll(String clinicIdValue)
}
