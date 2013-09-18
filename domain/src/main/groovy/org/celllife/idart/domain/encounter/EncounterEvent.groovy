package org.celllife.idart.domain.encounter


/**
 * Encounter Domain Event
 */
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
