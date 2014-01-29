package org.celllife.idart.application.part

import org.celllife.idart.application.part.dto.AtcCodeDto
import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.PersonId
import org.celllife.idart.common.SystemId


/**
 * Application service used to retrieve ATC codes from a particular provider
 */
interface AtcCodeApplicationService {

	/**
	 * Finds all the ATC codes available for a particular facility
	 * @param facilityId
	 * @return
	 */
    Set<AtcCodeDto> findByFacility(FacilityId facilityId)
	
	/**
	 * Finds all the ATC codes available for the facility associated with the specified System identifier
	 * @param system
	 * @return
	 */
	Set<AtcCodeDto> findBySystem(SystemId system)

	/**
	 * Finds all the ATC codes available for the facility associated with the specified User identifier
	 * (most probably none)
	 * @param personId
	 * @return
	 */
	Set<AtcCodeDto> findByPerson(PersonId personId)
}
