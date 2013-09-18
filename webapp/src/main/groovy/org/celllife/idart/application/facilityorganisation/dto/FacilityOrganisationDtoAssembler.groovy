package org.celllife.idart.application.facilityorganisation.dto

import org.celllife.idart.application.facility.FacilityApplicationService
import org.celllife.idart.application.organisation.OrganisationApplicationService
import org.celllife.idart.application.facilityorganisation.dto.FacilityOrganisationDto
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisation

import javax.inject.Inject
import javax.inject.Named

/**
 */
@Named class FacilityOrganisationDtoAssembler {

    @Inject FacilityApplicationService facilityApplicationService

    @Inject OrganisationApplicationService organisationApplicationService

    FacilityOrganisation toFacilityOrganisation(FacilityOrganisationDto facilityOrganisationDto) {

        def facilityOrganisation = new FacilityOrganisation()
        facilityOrganisation.with {
            facility = facilityApplicationService.findByIdentifiers(facilityOrganisationDto.facility)
            organisation = organisationApplicationService.findByIdentifiers(facilityOrganisationDto.organisation)
            relationship = facilityOrganisationDto.relationship
        }

        facilityOrganisation
    }

    FacilityOrganisationDto toFacilityOrganisationDto(FacilityOrganisation facilityOrganisation) {

        def facilityOrganisationDto = new FacilityOrganisationDto()
        facilityOrganisationDto.with {
            facility = facilityApplicationService.findByFacilityId(facilityOrganisation.facility).identifiers
            organisation = organisationApplicationService.findBySystemId(facilityOrganisation.organisation).identifiers
            relationship = facilityOrganisationDto.relationship
        }

        facilityOrganisationDto
    }
}
