package org.celllife.idart.domain.medication

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Medication Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class MedicationEvent {

    EventHeader header

    Medication medication

    static MedicationEvent newMedicationEvent(Medication medication, MedicationEvent.EventType eventType) {
        new MedicationEvent(medication: medication, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
