package org.celllife.idart.application.facility

import org.celllife.idart.application.facility.dto.FacilityDto
import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface FacilityApplicationService {

    Boolean exists(FacilityId facilityId)

    FacilityId save(FacilityDto facilityDto)

    FacilityDto findByFacilityId(FacilityId facilityId)

    FacilityDto findByIdentifier(Identifier identifier)

    FacilityId findByIdentifiers(Set<Identifier> identifiers)

}
