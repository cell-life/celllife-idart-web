package org.celllife.idart.relationship.patientorganisation

import org.celllife.idart.common.OrganisationId
import org.celllife.idart.common.PatientId

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h02
 */
interface PatientOrganisationRepository {

    PatientOrganisation save(PatientOrganisation practitionerOrganisation)

    PatientOrganisation findByPatientOrganisationRelationshipValid(PatientId patient,
                                                                   OrganisationId organisation,
                                                                   PatientOrganisation.Relationship relationship,
                                                                   Date validDate)

    Iterable<PatientOrganisation> findByPatientRelationshipValid(PatientId patient,
                                                                 PatientOrganisation.Relationship relationship,
                                                                 Date validDate)

    Iterable<PatientOrganisation> findByOrganisationRelationshipValid(OrganisationId organisation,
                                                                      PatientOrganisation.Relationship relationship,
                                                                      Date validDate)
}
