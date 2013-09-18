package org.celllife.idart.application.systemfacility.dto

import org.celllife.idart.application.encounter.EncounterApplicationService
import org.celllife.idart.application.facility.FacilityApplicationService
import org.celllife.idart.application.system.SystemApplicationService
import org.celllife.idart.relationship.systemfacility.SystemFacility

import javax.inject.Inject
import javax.inject.Named

/**
 */
@Named class SystemFacilityDtoAssembler {

    @Inject SystemApplicationService systemApplicationService

    @Inject FacilityApplicationService facilityApplicationService

    SystemFacility toSystemFacility(SystemFacilityDto systemFacilityDto) {

        def systemFacility = new SystemFacility()
        systemFacility.with {
            system = systemApplicationService.findByIdentifiers(systemFacilityDto.system)
            facility = facilityApplicationService.findByIdentifiers(systemFacilityDto.facility)
            relationship = systemFacilityDto.relationship
        }

        systemFacility
    }

    SystemFacilityDto toSystemFacilityDto(SystemFacility systemFacility) {

        def systemFacilityDto = new SystemFacilityDto()
        systemFacilityDto.with {
            system = systemApplicationService.findBySystemId(systemFacility.system).identifiers
            facility = facilityApplicationService.findByFacilityId(systemFacility.facility).identifiers
            relationship = systemFacilityDto.relationship
        }

        systemFacilityDto
    }
}
