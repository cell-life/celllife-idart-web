package org.celllife.idart.relationship.facilityorganisation

import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.OrganisationId

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h04
 */
public interface FacilityOrganisationService {

    void save(FacilityOrganisation facilityOrganisation)

    void save(FacilityId facility, OrganisationId organisation, FacilityOrganisation.Relationship relationship)

    Iterable<OrganisationId> findOrganisations(FacilityId facility, FacilityOrganisation.Relationship relationship)

}