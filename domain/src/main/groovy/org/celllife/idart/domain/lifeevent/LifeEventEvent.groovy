package org.celllife.idart.domain.lifeevent

import org.celllife.idart.common.EventHeader

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Life Event Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class LifeEventEvent implements Serializable {

    EventHeader header

    LifeEvent lifeEvent

    static LifeEventEvent newLifeEventEvent(LifeEvent lifeEvent, LifeEventEvent.EventType eventType) {
        new LifeEventEvent(lifeEvent: lifeEvent, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
