package org.celllife.idart.security.system

import org.celllife.idart.common.SystemId
import org.celllife.idart.domain.system.System
import org.celllife.idart.application.system.SystemApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SystemSecurityAdapter {

    @Inject SystemApplicationService systemApplicationService

    System save(Principal principal, System system) {
        systemApplicationService.save(system)
    }

    System findBySystemId(Principal principal, SystemId systemId) {
        systemApplicationService.findBySystemId(systemId)
    }

}
