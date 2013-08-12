package org.celllife.idart.domain.dispensedmedication

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * DispensedMedication Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DispensedMedicationEvent {

    EventHeader header

    DispensedMedication dispensedMedication

    static DispensedMedicationEvent newDispensedMedicationEvent(DispensedMedication dispensedMedication, DispensedMedicationEvent.EventType eventType) {
        new DispensedMedicationEvent(dispensedMedication: dispensedMedication, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
