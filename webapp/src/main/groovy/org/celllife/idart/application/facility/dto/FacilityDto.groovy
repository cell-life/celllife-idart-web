package org.celllife.idart.application.facility.dto

import org.celllife.idart.common.Quantity
import org.celllife.idart.common.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-15
 * Time: 13h20
 */
class FacilityDto {

    /**
     * Identified by
     */
    Set<Identifier> identifiers = [] as Set

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
    FacilityDto locatedAt

}
