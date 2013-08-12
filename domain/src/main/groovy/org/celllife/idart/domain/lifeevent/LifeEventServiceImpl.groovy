package org.celllife.idart.domain.lifeevent

import org.celllife.idart.common.LifeEventCode

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.lifeevent.LifeEventEvent.EventType.SAVED
import static org.celllife.idart.domain.lifeevent.LifeEventEvent.newLifeEventEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class LifeEventServiceImpl implements LifeEventService {

    @Autowired LifeEventRepository lifeEventRepository

    @Autowired LifeEventValidator lifeEventValidator

    @Autowired LifeEventEventPublisher lifeEventEventPublisher

    @Override
    LifeEvent save(LifeEvent lifeEvent) throws LifeEventValidationException {

        lifeEventValidator.validate(lifeEvent)

        lifeEventEventPublisher.publish(newLifeEventEvent(lifeEvent, SAVED))

        lifeEventRepository.save(lifeEvent)
    }

    @Override
    LifeEvent findByLifeEventCode(LifeEventCode lifeEventCode) throws LifeEventNotFoundException {

        def lifeEvent = lifeEventRepository.findOne(lifeEventCode)

        if (lifeEvent == null) {
            throw new LifeEventNotFoundException("Could not find LifeEvent with Life Event Code [${ lifeEventCode}]")
        }

        lifeEvent
    }
}