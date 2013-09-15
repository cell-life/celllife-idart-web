package org.celllife.idart.application.facility.dto

import org.celllife.idart.domain.facility.Facility

/**
 */
class FacilityDtoAssembler {

    static Facility toFacility(FacilityDto facilityDto) {

        def facility = new Facility()
        facility.with {
            name = facilityDto.name
            description = facilityDto.description
            area = facilityDto.area
        }

        facility
    }

    static FacilityDto toFacilityDto(Facility facility) {

        def facilityDto = new FacilityDto()
        facilityDto.with {
            name = facility.name
            description = facility.description
            area = facility.area
        }

        facilityDto
    }
}
