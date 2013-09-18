package org.celllife.idart.domain.prescription

import javax.annotation.Generated

/**
 * Prescription Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PrescriptionEvent implements Serializable {

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
        SAVED
    }
}
