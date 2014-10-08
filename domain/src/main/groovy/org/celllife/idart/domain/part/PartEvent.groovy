package org.celllife.idart.domain.part

import groovy.transform.ToString


/**
 * Part Domain Event
 */
@ToString
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
