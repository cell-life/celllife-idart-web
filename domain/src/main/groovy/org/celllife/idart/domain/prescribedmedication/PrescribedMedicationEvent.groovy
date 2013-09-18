package org.celllife.idart.domain.prescribedmedication

import javax.annotation.Generated

/**
 * PrescribedMedication Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PrescribedMedicationEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    PrescribedMedication prescribedMedication

    static PrescribedMedicationEvent newPrescribedMedicationEvent(PrescribedMedication prescribedMedication, PrescribedMedicationEvent.EventType eventType) {

        new PrescribedMedicationEvent(
            prescribedMedication: prescribedMedication,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
