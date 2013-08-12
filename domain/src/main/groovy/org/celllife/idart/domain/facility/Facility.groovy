package org.celllife.idart.domain.facility

import org.celllife.idart.common.FacilityIdentifier
import org.celllife.idart.common.Quantity

/**
 * Facility 
 *
 */
class Facility {

    /**
     * Namespace
     */
    static NAMESPACE = "http://www.cell-life.org/idart/facilities"

    /**
     * Facility Identifier 
     */
    FacilityIdentifier identifier

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
    FacilityIdentifier locatedAt

    def merge(Facility that) {

        if (that == null) {
            return
        }

        this.name = that.name
        this.description = that.description
        this.area = that.area
    }
}