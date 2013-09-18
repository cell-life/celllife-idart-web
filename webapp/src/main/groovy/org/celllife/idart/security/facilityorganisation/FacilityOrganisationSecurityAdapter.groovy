package org.celllife.idart.security.facilityorganisation

import org.celllife.idart.application.facilityorganisation.FacilityOrganisationApplicationService
import org.celllife.idart.application.facilityorganisation.dto.FacilityOrganisationDto

import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-17
 * Time: 19h43
 */
@Named class FacilityOrganisationSecurityAdapter {

    @Inject FacilityOrganisationApplicationService facilityOrganisationApplicationService

    void save(Principal principal, FacilityOrganisationDto facilityOrganisationDto) {
        facilityOrganisationApplicationService.save(facilityOrganisationDto)
    }

}
