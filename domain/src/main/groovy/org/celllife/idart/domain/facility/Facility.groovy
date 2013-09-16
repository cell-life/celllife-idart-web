package org.celllife.idart.domain.facility

import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.Quantity

/**
 * Facility 
 *
 */
class Facility implements Serializable {

    /**
     * Facility Id
     */
    FacilityId id

    /**
     * Name
     */
    String name

    /**
     * Described by
     */
    String description

    /**
     * Surface Area
     */
    Quantity area

    /**
     * Located at
     */
    FacilityId locatedAt

    def merge(Facility that) {

        if (that == null) {
            return
        }

        this.name = that.name
        this.description = that.description
        this.area = that.area
    }
}
