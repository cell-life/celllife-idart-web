package org.celllife.idart.application.system

import org.celllife.idart.application.system.dto.SystemDto
import org.celllife.idart.common.SystemId
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface SystemApplicationService {

    Boolean exists(SystemId systemId)

    SystemId save(SystemDto systemDto)

    SystemDto findBySystemId(SystemId systemId)

    SystemDto findByIdentifier(Identifier identifier)

}
