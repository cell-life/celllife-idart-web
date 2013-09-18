package org.celllife.idart.domain.entrysite

import javax.annotation.Generated

/**
 * Entry Site Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EntrySiteEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    EntrySite entrySite

    static EntrySiteEvent newEntrySiteEvent(EntrySite entrySite, EntrySiteEvent.EventType eventType) {

        new EntrySiteEvent(
            entrySite: entrySite,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
