package org.celllife.idart.relationship.practitionerorganisation

import org.celllife.idart.common.OrganisationId
import org.celllife.idart.common.Period
import org.celllife.idart.common.PractitionerId

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 14h59
 */
class PractitionerOrganisation implements Serializable {

    enum Relationship {

        CONTRACTED_BY

    }

    Long pk

    PractitionerId practitioner

    OrganisationId organisation

    Relationship relationship

    Period valid


}
