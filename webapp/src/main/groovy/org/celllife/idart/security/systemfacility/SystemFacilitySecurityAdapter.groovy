package org.celllife.idart.security.systemfacility

import org.celllife.idart.application.systemfacility.SystemFacilityApplicationService
import org.celllife.idart.application.systemfacility.dto.SystemFacilityDto

import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-17
 * Time: 19h36
 */
@Named class SystemFacilitySecurityAdapter {

    @Inject SystemFacilityApplicationService systemFacilityApplicationService

    void save(Principal principal, SystemFacilityDto systemFacilityDto) {
        systemFacilityApplicationService.save(systemFacilityDto)
    }
}
