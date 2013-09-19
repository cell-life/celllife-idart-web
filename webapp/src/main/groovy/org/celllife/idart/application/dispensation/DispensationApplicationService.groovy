package org.celllife.idart.application.dispensation

import org.celllife.idart.application.dispensation.dto.DispensationDto
import org.celllife.idart.common.DispensationId
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.SystemId


/**
 */
interface DispensationApplicationService {

    Boolean exists(DispensationId dispensationId)

    DispensationId save(SystemId system, DispensationDto dispensationDto)

    DispensationId save(DispensationDto dispensationDto)

    DispensationDto findByDispensationId(DispensationId dispensationId)

    DispensationDto findByIdentifier(Identifier identifier)

    DispensationId findByIdentifiers(Set<Identifier> identifiers)

}
