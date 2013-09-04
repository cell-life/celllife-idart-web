package org.celllife.idart.application.system

import org.celllife.idart.common.SystemId
import org.celllife.idart.domain.system.System

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface SystemApplicationService {

    System save(System system)

    System findBySystemId(SystemId systemId)

}
