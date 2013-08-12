package org.celllife.idart.application.facility

import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.facility.FacilityValidationException
import org.celllife.idart.domain.facility.FacilityNotFoundException
import org.celllife.idart.common.FacilityIdentifier
import org.celllife.idart.domain.facility.FacilityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class FacilityApplicationServiceImpl implements FacilityApplicationService {

    @Autowired FacilityService facilityService

    Facility save(Facility facility) throws FacilityValidationException {
        facilityService.save(facility)
    }

    Facility findByFacilityIdentifier(FacilityIdentifier facilityIdentifier) throws FacilityNotFoundException{
        facilityService.findByFacilityIdentifier(facilityIdentifier)
    }

}