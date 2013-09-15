package org.celllife.idart.relationship.practitionerorganisation

import org.celllife.idart.common.OrganisationId
import org.celllife.idart.common.PractitionerId

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h02
 */
interface PractitionerOrganisationRepository {

    PractitionerOrganisation save(PractitionerOrganisation practitionerOrganisation)

    PractitionerOrganisation findByPractitionerOrganisationRelationshipValid(PractitionerId practitioner,
                                                                             OrganisationId organisation,
                                                                             PractitionerOrganisation.Relationship relationship,
                                                                             Date validDate)

    Iterable<PractitionerOrganisation> findByPractitionerRelationshipValid(PractitionerId practitioner,
                                                                           PractitionerOrganisation.Relationship relationship,
                                                                           Date validDate)

    Iterable<PractitionerOrganisation> findByOrganisationRelationshipValid(OrganisationId organisation,
                                                                           PractitionerOrganisation.Relationship relationship,
                                                                           Date validDate)
}
