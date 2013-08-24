package org.celllife.idart.application.facility

import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.facility.FacilityValidationException
import org.celllife.idart.domain.facility.FacilityNotFoundException
import org.celllife.idart.common.FacilityId
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

    Facility findByFacilityId(FacilityId facilityId) throws FacilityNotFoundException{
        facilityService.findByFacilityId(facilityId)
    }

}
