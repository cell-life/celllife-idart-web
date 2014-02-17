package org.celllife.idart.domain.dispensation


/**
 * Dispensation Domain Event
 */
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
        SAVED, DELETED
    }
}
