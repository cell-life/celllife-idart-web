package org.celllife.idart.security.system

import org.celllife.idart.application.system.dto.SystemDto
import org.celllife.idart.common.SystemId
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.system.SystemApplicationService

import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Named class SystemSecurityAdapter {

    @Inject SystemApplicationService systemApplicationService

    SystemId save(Principal principal, SystemDto systemDto) {
        systemApplicationService.save(systemDto)
    }

    SystemDto findBySystemId(Principal principal, SystemId systemId) {
        systemApplicationService.findBySystemId(systemId)
    }

    SystemDto findByIdentifier(Principal principal, Identifier identifier) {
        systemApplicationService.findByIdentifier(identifier)
    }

}
