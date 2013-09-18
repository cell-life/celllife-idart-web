package org.celllife.idart.domain.system


/**
 * System Domain Event
 */
class SystemEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    System system

    static SystemEvent newSystemEvent(System system, SystemEvent.EventType eventType) {

        new SystemEvent(
            system: system,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
