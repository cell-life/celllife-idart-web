package org.celllife.idart.relationship.patientorganisation

import org.celllife.idart.common.OrganisationId
import org.celllife.idart.common.PatientId

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h04
 */
public interface PatientOrganisationService {

    void save(PatientId patient, OrganisationId organisation, PatientOrganisation.Relationship relationship)

    Iterable<OrganisationId> findOrganisations(PatientId patient, PatientOrganisation.Relationship relationship)

    Iterable<PatientId> findPatients(OrganisationId organisationId, PatientOrganisation.Relationship relationship)
}