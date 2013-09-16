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
    Boolean exists(LifeEventCode lifeEventCode) {
        lifeEventRepository.exists(lifeEventCode)
    }

    @Override
    LifeEvent save(LifeEvent lifeEvent) {

        def existingLifeEvent = lifeEventRepository.findOne(lifeEvent.id)

        if (existingLifeEvent == null) {
            existingLifeEvent = lifeEvent
        } else {
            existingLifeEvent.merge(lifeEvent)
        }

        lifeEventValidator.validate(existingLifeEvent)

        lifeEventEventPublisher.publish(newLifeEventEvent(existingLifeEvent, SAVED))

        lifeEventRepository.save(existingLifeEvent)
    }

    @Override
    LifeEvent findByLifeEventCode(LifeEventCode lifeEventCode) {

        def lifeEvent = lifeEventRepository.findOne(lifeEventCode)

        if (lifeEvent == null) {
            throw new LifeEventNotFoundException("Could not find LifeEvent with code [${ lifeEventCode}]")
        }

        lifeEvent
    }
}
