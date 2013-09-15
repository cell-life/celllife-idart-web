package org.celllife.idart.relationship.facilityorganisation

import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.OrganisationId

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h02
 */
interface FacilityOrganisationRepository {

    FacilityOrganisation save(FacilityOrganisation facilityOrganisation)

    FacilityOrganisation findByFacilityOrganisationRelationshipValid(FacilityId facility,
                                                                     OrganisationId organisation,
                                                                     FacilityOrganisation.Relationship relationship,
                                                                     Date validDate)

    Iterable<FacilityOrganisation> findByFacilityRelationshipValid(FacilityId facility,
                                                                   FacilityOrganisation.Relationship relationship,
                                                                   Date validDate)
}
