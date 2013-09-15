package org.celllife.idart.relationship.practitionerorganisation

import org.celllife.idart.common.OrganisationId
import org.celllife.idart.common.PractitionerId

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h04
 */
public interface PractitionerOrganisationService {

    void save(PractitionerId practitioner,
              OrganisationId organisation,
              PractitionerOrganisation.Relationship relationship)

    Iterable<OrganisationId> findOrganisations(PractitionerId practitioner,
                                               PractitionerOrganisation.Relationship relationship)

    Iterable<PractitionerId> findPractitioners(OrganisationId organisationId,
                                               PractitionerOrganisation.Relationship relationship)
}