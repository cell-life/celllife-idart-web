package org.celllife.idart.domain.dispensation

import javax.annotation.Generated

/**
 * Dispensation Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DispensationEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    Dispensation dispensation

    static DispensationEvent newDispensationEvent(Dispensation dispensation, DispensationEvent.EventType eventType) {

        new DispensationEvent(
            dispensation: dispensation,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
