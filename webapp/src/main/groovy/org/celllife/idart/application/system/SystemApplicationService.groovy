package org.celllife.idart.application.system

import org.celllife.idart.domain.system.System
import org.celllife.idart.domain.system.SystemValidationException
import org.celllife.idart.domain.system.SystemNotFoundException
import org.celllife.idart.common.SystemId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface SystemApplicationService {

    System save(System system) throws SystemValidationException

    System findBySystemId(SystemId systemId) throws SystemNotFoundException

}
