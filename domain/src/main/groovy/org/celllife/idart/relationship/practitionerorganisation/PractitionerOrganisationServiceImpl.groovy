package org.celllife.idart.relationship.practitionerorganisation

import org.celllife.idart.common.OrganisationId
import org.celllife.idart.common.PractitionerId

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.common.Period.newPeriod

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h04
 */
@Named class PractitionerOrganisationServiceImpl implements PractitionerOrganisationService {

    @Inject PractitionerOrganisationRepository practitionerOrganisationRepository

    @Override
    Iterable<OrganisationId> findOrganisations(PractitionerId practitioner,
                                               PractitionerOrganisation.Relationship relationship) {

        practitionerOrganisationRepository
                .findByPractitionerRelationshipValid(practitioner, relationship, new Date())
                .collect { practitionerOrganisation -> practitionerOrganisation.organisation }
    }

    @Override
    Iterable<PractitionerId> findPractitioners(OrganisationId organisationId,
                                               PractitionerOrganisation.Relationship relationship) {

        practitionerOrganisationRepository
                .findByOrganisationRelationshipValid(organisationId, relationship, new Date())
                .collect { practitionerOrganisation -> practitionerOrganisation.practitioner }
    }

    void save(PractitionerId practitioner,
              OrganisationId organisation,
              PractitionerOrganisation.Relationship relationship) {

        def practitionerOrganisation = practitionerOrganisationRepository
                .findByPractitionerOrganisationRelationshipValid(practitioner, organisation, relationship, new Date())

        if (practitionerOrganisation == null) {
            practitionerOrganisation = new PractitionerOrganisation(
                    practitioner: practitioner,
                    organisation: organisation,
                    relationship: relationship,
                    valid: newPeriod()
            )

            practitionerOrganisationRepository.save(practitionerOrganisation)
        }
    }
}
