package org.celllife.idart.application.lifeevent

import org.celllife.idart.domain.lifeevent.LifeEvent
import org.celllife.idart.domain.lifeevent.LifeEventValidationException
import org.celllife.idart.domain.lifeevent.LifeEventNotFoundException
import org.celllife.idart.common.LifeEventCode
import org.celllife.idart.domain.lifeevent.LifeEventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class LifeEventApplicationServiceImpl implements LifeEventApplicationService {

    @Autowired LifeEventService lifeEventService

    LifeEvent save(LifeEvent lifeEvent) throws LifeEventValidationException {
        lifeEventService.save(lifeEvent)
    }

    LifeEvent findByLifeEventCode(LifeEventCode lifeEventCode) throws LifeEventNotFoundException{
        lifeEventService.findByLifeEventCode(lifeEventCode)
    }

}