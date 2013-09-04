package org.celllife.idart.application.patient.dto

import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.common.Period
import org.celllife.idart.domain.identifiable.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-23
 * Time: 18h36
 */
class PatientDto {

    /**
     * Identified by
     */
    Set<Identifier> identifiers

    /**
     * Valid during
     */
    Period valid

    /**
     * Acted by
     */
    PersonDto person

}
