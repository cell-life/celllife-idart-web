package org.celllife.idart.domain.prescribedmedication

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * PrescribedMedication Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PrescribedMedicationEvent {

    EventHeader header

    PrescribedMedication prescribedMedication

    static PrescribedMedicationEvent newPrescribedMedicationEvent(PrescribedMedication prescribedMedication, PrescribedMedicationEvent.EventType eventType) {
        new PrescribedMedicationEvent(prescribedMedication: prescribedMedication, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
