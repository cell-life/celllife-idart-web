package org.celllife.idart.domain.patient

import javax.annotation.Generated

/**
 * Patient Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PatientEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    Patient patient

    static PatientEvent newPatientEvent(Patient patient, PatientEvent.EventType eventType) {

        new PatientEvent(
            patient: patient,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
