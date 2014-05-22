package org.celllife.idart.application.practitioner.dto

import groovy.transform.EqualsAndHashCode;

import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.common.Period
import org.celllife.idart.common.PractitionerType
import org.celllife.idart.common.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 13h00
 */
@EqualsAndHashCode
class PractitionerDto implements Serializable {

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    /**
     * Of Type
     */
    PractitionerType type

    /**
     * Valid during
     */
    Period valid

    /**
     * Acted by
     */
    PersonDto person
}
