package org.celllife.idart.application.patient.dto

import groovy.transform.EqualsAndHashCode;

import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.common.Period
import org.celllife.idart.common.Identifier

/**
 * A Data Transfer Object for the Patient Entity
 */
@EqualsAndHashCode
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

    @Override
    public String toString() {
        return "PatientDto [identifiers=" + identifiers + ", valid=" + valid + ", person=" + person + "]";
    }
}
