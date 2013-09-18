package org.celllife.idart.domain.prescribedmedication


/**
 * PrescribedMedication Domain Event
 */
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
