package org.celllife.idart.application.patient.dto

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.Period

/**
 * A Data Transfer Object for the Patient Entity
 */
@EqualsAndHashCode
@ToString
class PatientDto implements Serializable {

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    /**
     * Valid during
     */
    Period valid

    /**
     * Acted by
     */
    PersonDto person

}
