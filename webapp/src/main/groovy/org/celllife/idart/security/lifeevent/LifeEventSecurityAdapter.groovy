package org.celllife.idart.security.lifeevent

import org.celllife.idart.common.LifeEventCode
import org.celllife.idart.domain.lifeevent.LifeEvent
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

    LifeEvent save(Principal principal, LifeEvent lifeEvent) {
        lifeEventApplicationService.save(lifeEvent)
    }

    LifeEvent findByLifeEventCode(Principal principal, LifeEventCode lifeEventCode) {
        lifeEventApplicationService.findByLifeEventCode(lifeEventCode)
    }

}
