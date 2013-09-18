package org.celllife.idart.relationship.facilityorganisation

import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.OrganisationId

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.common.Period.newPeriod

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h04
 */
@Named class FacilityOrganisationServiceImpl implements FacilityOrganisationService {

    @Inject FacilityOrganisationRepository facilityOrganisationRepository

    @Override
    void save(FacilityOrganisation facilityOrganisation) {
        save(facilityOrganisation.facility, facilityOrganisation.organisation, facilityOrganisation.relationship)
    }

    @Override
    void save(FacilityId facility, OrganisationId organisation, FacilityOrganisation.Relationship relationship) {

        def facilityOrganisation = facilityOrganisationRepository
                .findByFacilityOrganisationRelationshipValid(facility, organisation, relationship, new Date())

        if (facilityOrganisation == null) {
            facilityOrganisation = new FacilityOrganisation(
                    facility: facility,
                    organisation: organisation,
                    relationship: relationship,
                    valid: newPeriod()
            )

            facilityOrganisationRepository.save(facilityOrganisation)
        }
    }

    @Override
    Iterable<OrganisationId> findOrganisations(FacilityId facility, FacilityOrganisation.Relationship relationship) {
        facilityOrganisationRepository
                .findByFacilityRelationshipValid(facility, relationship, new Date())
                .collect { facilityOrganisation -> facilityOrganisation.organisation }
    }
}
