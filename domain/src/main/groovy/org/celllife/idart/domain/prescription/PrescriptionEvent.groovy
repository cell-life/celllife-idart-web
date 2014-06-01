package org.celllife.idart.domain.prescription

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


/**
 * Prescription Domain Event
 */
@ToString
@EqualsAndHashCode
class PrescriptionEvent implements Serializable {

    private static final long serialVersionUID = 530452930120313802L;
    
    Date timestamp

    UUID uuid

    EventType type

    String username

    Prescription prescription

    static PrescriptionEvent newPrescriptionEvent(Prescription prescription, PrescriptionEvent.EventType eventType) {

        new PrescriptionEvent(
            prescription: prescription,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED,
		DELETED
    }
}
