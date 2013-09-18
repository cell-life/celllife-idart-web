package org.celllife.idart.domain.part

import javax.annotation.Generated

/**
 * Part Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PartEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    Part part

    static PartEvent newPartEvent(Part part, PartEvent.EventType eventType) {

        new PartEvent(
            part: part,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
