package org.celllife.idart.security.lifeevent

import org.celllife.idart.application.lifeevent.dto.LifeEventDto
import org.celllife.idart.common.LifeEventCode
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.lifeevent.LifeEventApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class LifeEventSecurityAdapter {

    @Inject LifeEventApplicationService lifeEventApplicationService

    LifeEventCode save(Principal principal, LifeEventDto lifeEventDto) {
        lifeEventApplicationService.save(lifeEventDto)
    }

    LifeEventDto findByLifeEventCode(Principal principal, LifeEventCode lifeEventCode) {
        lifeEventApplicationService.findByLifeEventCode(lifeEventCode)
    }

    LifeEventDto findByIdentifier(Principal principal, Identifier identifier) {
        lifeEventApplicationService.findByIdentifier(identifier)
    }

}
