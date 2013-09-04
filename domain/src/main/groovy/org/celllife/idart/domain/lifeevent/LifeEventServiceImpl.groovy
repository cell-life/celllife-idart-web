package org.celllife.idart.domain.lifeevent

import org.celllife.idart.common.LifeEventCode

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.lifeevent.LifeEventEvent.EventType.SAVED
import static org.celllife.idart.domain.lifeevent.LifeEventEvent.newLifeEventEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class LifeEventServiceImpl implements LifeEventService {

    @Inject LifeEventRepository lifeEventRepository

    @Inject LifeEventValidator lifeEventValidator

    @Inject LifeEventEventPublisher lifeEventEventPublisher

    @Override
    LifeEvent save(LifeEvent lifeEvent) {

        lifeEventValidator.validate(lifeEvent)

        lifeEventEventPublisher.publish(newLifeEventEvent(lifeEvent, SAVED))

        lifeEventRepository.save(lifeEvent)
    }

    @Override
    LifeEvent findByLifeEventCode(LifeEventCode lifeEventCode) {

        def lifeEvent = lifeEventRepository.findOne(lifeEventCode)

        if (lifeEvent == null) {
            throw new LifeEventNotFoundException("Could not find LifeEvent with Life Event Code [${ lifeEventCode}]")
        }

        lifeEvent
    }
}
