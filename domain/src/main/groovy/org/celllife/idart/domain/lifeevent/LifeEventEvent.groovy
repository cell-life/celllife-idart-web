package org.celllife.idart.domain.lifeevent

import javax.annotation.Generated

/**
 * Life Event Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class LifeEventEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    LifeEvent lifeEvent

    static LifeEventEvent newLifeEventEvent(LifeEvent lifeEvent, LifeEventEvent.EventType eventType) {

        new LifeEventEvent(
            lifeEvent: lifeEvent,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
