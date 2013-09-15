package org.celllife.idart.security.system

import org.celllife.idart.application.system.dto.SystemDto
import org.celllife.idart.common.SystemId
import org.celllife.idart.domain.identifiable.Identifier
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

    SystemId save(Principal principal, systemDto) {
        systemApplicationService.save(systemDto)
    }

    SystemDto findBySystemId(Principal principal, SystemId systemId) {
        systemApplicationService.findBySystemId(systemId)
    }

    SystemDto findByIdentifier(Principal principal, Identifier identifier) {
        systemApplicationService.findByIdentifier(identifier)
    }

}
