package org.celllife.idart.domain.facility

import org.celllife.idart.common.FacilityIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface FacilityService {

    Facility save(Facility facility) throws FacilityValidationException

    Facility findByFacilityIdentifier(FacilityIdentifier facilityIdentifier) throws FacilityNotFoundException

}