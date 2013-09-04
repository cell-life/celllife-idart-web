package org.celllife.idart.application.lifeevent

import org.celllife.idart.common.LifeEventCode
import org.celllife.idart.domain.lifeevent.LifeEvent
import org.celllife.idart.domain.lifeevent.LifeEventService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class LifeEventApplicationServiceImpl implements LifeEventApplicationService {

    @Inject LifeEventService lifeEventService

    LifeEvent save(LifeEvent lifeEvent) {
        lifeEventService.save(lifeEvent)
    }

    LifeEvent findByLifeEventCode(LifeEventCode lifeEventCode) {
        lifeEventService.findByLifeEventCode(lifeEventCode)
    }

}
