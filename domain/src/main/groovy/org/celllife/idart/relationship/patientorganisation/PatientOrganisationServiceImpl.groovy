package org.celllife.idart.relationship.patientorganisation

import org.celllife.idart.common.OrganisationId
import org.celllife.idart.common.PatientId

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.common.Period.newPeriod

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h04
 */
@Named class PatientOrganisationServiceImpl implements PatientOrganisationService {

    @Inject PatientOrganisationRepository patientOrganisationRepository

    @Override
    Iterable<OrganisationId> findOrganisations(PatientId patient, PatientOrganisation.Relationship relationship) {

        patientOrganisationRepository
                .findByPatientRelationshipValid(patient, relationship, new Date())
                .collect { patientOrganisation -> patientOrganisation.organisation }
    }

    @Override
    Iterable<PatientId> findPatients(OrganisationId organisationId, PatientOrganisation.Relationship relationship) {

        patientOrganisationRepository
                .findByOrganisationRelationshipValid(organisationId, relationship, new Date())
                .collect { patientOrganisation -> patientOrganisation.patient }
    }

    void save(PatientId patient, OrganisationId organisation, PatientOrganisation.Relationship relationship) {

        def patientOrganisation = patientOrganisationRepository
                .findByPatientOrganisationRelationshipValid(patient, organisation, relationship, new Date())

        if (patientOrganisation == null) {
            patientOrganisation = new PatientOrganisation(
                    patient: patient,
                    organisation: organisation,
                    relationship: relationship,
                    valid: newPeriod()
            )

            patientOrganisationRepository.save(patientOrganisation)
        }
    }
}
