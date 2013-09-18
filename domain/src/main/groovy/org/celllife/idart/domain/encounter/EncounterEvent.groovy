package org.celllife.idart.domain.encounter

import javax.annotation.Generated

/**
 * Encounter Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EncounterEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    Encounter encounter

    static EncounterEvent newEncounterEvent(Encounter encounter, EncounterEvent.EventType eventType) {

        new EncounterEvent(
            encounter: encounter,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
