package org.celllife.idart.domain.encounter

import org.celllife.idart.common.EventHeader

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Encounter Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EncounterEvent implements Serializable {

    EventHeader header

    Encounter encounter

    static EncounterEvent newEncounterEvent(Encounter encounter, EncounterEvent.EventType eventType) {
        new EncounterEvent(encounter: encounter, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
