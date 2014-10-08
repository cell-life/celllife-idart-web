package org.celllife.idart.relationship.facilityorganisation

import groovy.transform.ToString

import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.OrganisationId
import org.celllife.idart.common.Period

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 14h59
 */
@ToString
class FacilityOrganisation implements Serializable {

    enum Relationship {

        OPERATED_BY,
        OWNED_BY

    }

    Long pk

    FacilityId facility

    OrganisationId organisation

    Relationship relationship

    Period valid

}
