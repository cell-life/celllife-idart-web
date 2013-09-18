package org.celllife.idart.application.facilityorganisation.dto

import org.celllife.idart.common.Identifier
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisation

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-17
 * Time: 19h43
 */
class FacilityOrganisationDto implements Serializable {

    Set<Identifier> facility

    Set<Identifier> organisation

    FacilityOrganisation.Relationship relationship

}
