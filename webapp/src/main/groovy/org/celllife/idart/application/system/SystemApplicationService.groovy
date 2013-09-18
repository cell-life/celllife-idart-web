package org.celllife.idart.application.system

import org.celllife.idart.application.system.dto.SystemDto
import org.celllife.idart.common.SystemId
import org.celllife.idart.common.Identifier


/**
 */
interface SystemApplicationService {

    Boolean exists(SystemId systemId)

    SystemId save(SystemDto systemDto)

    SystemDto findBySystemId(SystemId systemId)

    SystemDto findByIdentifier(Identifier identifier)

    SystemId findByIdentifiers(Set<Identifier> identifiers)

}
