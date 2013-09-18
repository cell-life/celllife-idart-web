package org.celllife.idart.domain.practitioner

import javax.annotation.Generated

/**
 * Practitioner Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PractitionerEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    Practitioner practitioner

    static PractitionerEvent newPractitionerEvent(Practitioner practitioner, PractitionerEvent.EventType eventType) {

        new PractitionerEvent(
            practitioner: practitioner,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
