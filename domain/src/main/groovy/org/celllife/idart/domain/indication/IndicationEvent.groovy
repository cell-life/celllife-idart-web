package org.celllife.idart.domain.indication

import javax.annotation.Generated

/**
 * Indication Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class IndicationEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    Indication indication

    static IndicationEvent newIndicationEvent(Indication indication, IndicationEvent.EventType eventType) {

        new IndicationEvent(
            indication: indication,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
