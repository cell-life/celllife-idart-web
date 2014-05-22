package org.celllife.idart.application.part.dto

import groovy.transform.EqualsAndHashCode

import org.celllife.idart.common.FormCode
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.Label
import org.celllife.idart.common.Quantity
import org.celllife.idart.domain.part.PartClassificationApplication

/**
 * A Data Transfer Object (DTO) which represents the Part domain entity.
 */
@EqualsAndHashCode
abstract class PartDto implements Serializable {

    /**
     * Identified by
     */
    Set<Identifier> identifiers = [] as Set

    /**
     * Labelled as
     */
    Label label

    /**
     * The amount
     */
    Quantity quantity

    /**
     * The form (e.g. for drugs: TAB, CAP)
     */
    FormCode form

    /**
     * Classified into
     */
    Set<PartClassificationApplication> classifications = []

    @Override
    public String toString() {
        return "PartDto [identifiers=" + identifiers + ", label=" + label + ", quantity=" + quantity + ", form=" + form
                + ", classifications=" + classifications + "]";
    }
}
