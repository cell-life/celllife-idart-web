package org.celllife.idart.domain.dispensation

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


/**
 * Dispensation Domain Event
 */
@ToString
@EqualsAndHashCode
class DispensationEvent implements Serializable {

    private static final long serialVersionUID = 530452930800314802L;

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
        SAVED, DELETED, UPDATED
    }
}
