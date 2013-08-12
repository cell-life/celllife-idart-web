package org.celllife.idart.application.facility

import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.facility.FacilityValidationException
import org.celllife.idart.domain.facility.FacilityNotFoundException
import org.celllife.idart.common.FacilityIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface FacilityApplicationService {

    Facility save(Facility facility) throws FacilityValidationException

    Facility findByFacilityIdentifier(FacilityIdentifier facilityIdentifier) throws FacilityNotFoundException

}