package org.celllife.idart.application.system

import org.celllife.idart.common.SystemId
import org.celllife.idart.domain.system.System
import org.celllife.idart.domain.system.SystemService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SystemApplicationServiceImpl implements SystemApplicationService {

    @Inject SystemService systemService

    System save(System system) {
        systemService.save(system)
    }

    System findBySystemId(SystemId systemId) {
        systemService.findBySystemId(systemId)
    }

}
