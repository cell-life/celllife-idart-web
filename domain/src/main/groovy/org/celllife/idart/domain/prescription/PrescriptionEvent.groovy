package org.celllife.idart.domain.prescription

import org.celllife.idart.common.EventHeader

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Prescription Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PrescriptionEvent implements Serializable {

    EventHeader header

    Prescription prescription

    static PrescriptionEvent newPrescriptionEvent(Prescription prescription, PrescriptionEvent.EventType eventType) {
        new PrescriptionEvent(prescription: prescription, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
